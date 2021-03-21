package com.flights.api.configuration;

import com.flights.api.aspect.Interceptor;
import com.flights.api.aspect.RezervarePriceValidation;
import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectConfig {

    @Bean
    public Interceptor interceptor() {
        return Aspects.aspectOf(Interceptor.class);
    }

    @Bean
    public RezervarePriceValidation validation() {
        return Aspects.aspectOf(RezervarePriceValidation.class);
    }
}
