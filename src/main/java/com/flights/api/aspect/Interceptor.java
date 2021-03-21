package com.flights.api.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@Aspect
public class Interceptor {

	private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);

	@Before("execution(* *(..)) && !within(com.flights.api.aspect.Interceptor)"
			+ " && (within(org.springframework.context.annotation.Condition+) || within(com.flights.api..*))")
	public void intercept(JoinPoint joinPoint) {
		logger.debug("AspectJ intercept: " + joinPoint.toShortString());
	}

	@Around("execution(* *(..)) && within(com.flights.api..*) && !within(com.flights.api.aspect.Interceptor+)")
	public Object stack(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.debug("AspectJ stack: " + joinPoint.toShortString());
		return joinPoint.proceed();
	}

	@EventListener
	public void started(ContextRefreshedEvent event) {
		logger.info("AspectJ started: Startup " + event);
	}

}
