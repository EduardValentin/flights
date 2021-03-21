package com.flights.api.aspect;

import com.flights.api.SpringApplicationContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


@Aspect
@Configuration
@DependsOn("springApplicationContextHolder")
public class TransactionalAspect {

    private static final Logger logger = LoggerFactory.getLogger(TransactionalAspect.class);

    @Around(value = "call(* com.flights.api.repository.*.saveAll(java.lang.Iterable)) " +
            "&& args(items,..)", argNames = "proceedingJoinPoint,items")
    public Object doTransaction(ProceedingJoinPoint proceedingJoinPoint, Iterable<?> items) throws Throwable {

        logger.info("Saving multiple items. From method" + proceedingJoinPoint.toShortString());

        try {
            return proceedingJoinPoint.proceed();
        } catch (Exception ex) {
            logger.info("Error while saving multiple items. From method" + proceedingJoinPoint.toShortString());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw ex;
        }
    }

    public static TransactionalAspect aspectOf() {
        return SpringApplicationContextHolder.getApplicationContext().getBean(TransactionalAspect.class);
    }
}
