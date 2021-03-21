package com.flights.api.aspect;

import com.flights.api.dto.RezervareDto;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Aspect
public class RezervarePriceValidation {

    private static final Logger logger = LoggerFactory.getLogger(RezervarePriceValidation.class);

    @Before("execution(* com.flights.api.service.RezervareService.create(com.flights.api.dto.RezervareDto)) && args(rezervareDto,..)")
    public void validate(RezervareDto rezervareDto) {

        if (rezervareDto.getDiscount() > 90) {
            logger.error("Discount can't be greater than 90");
            throw new ResponseStatusException(BAD_REQUEST);
        }

        if (rezervareDto.getPret() == 0) {
            logger.error("Price can't be zero");
            throw new ResponseStatusException(BAD_REQUEST);
        }
    }
}
