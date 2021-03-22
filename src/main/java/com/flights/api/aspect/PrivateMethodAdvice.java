package com.flights.api.aspect;

import com.flights.api.SpringApplicationContextHolder;
import com.flights.api.dto.RezervareDto;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Aspect
@Configuration
@DependsOn("springApplicationContextHolder")
public class PrivateMethodAdvice {

    private static final Logger logger = LoggerFactory.getLogger(RezervarePriceValidation.class);

    @Pointcut("execution(private void com.flights.api.service.AvionService.mockPrivateMethod())")
    public void privateMethodPointcut() {
    }

    @AfterReturning(pointcut = "privateMethodPointcut()")
    public void privateMethodAdvice() {

        logger.info("Inside private method advice");
    }

    public static PrivateMethodAdvice aspectOf() {
        return SpringApplicationContextHolder.getApplicationContext().getBean(PrivateMethodAdvice.class);
    }
}
