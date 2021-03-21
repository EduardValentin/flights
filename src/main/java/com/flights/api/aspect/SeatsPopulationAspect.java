package com.flights.api.aspect;

import com.flights.api.SpringApplicationContextHolder;
import com.flights.api.dto.CreateAvionDto;
import com.flights.api.model.Avion;
import com.flights.api.model.Clasa;
import com.flights.api.model.Loc;
import com.flights.api.model.MarcaAvion;
import com.flights.api.repository.ClasaRepository;
import com.flights.api.repository.LocRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Aspect
@Configuration
@DependsOn("springApplicationContextHolder")
public class SeatsPopulationAspect {

    private final String DENUMIRE_CLASA = "Clasa I";

    private static final Logger logger = LoggerFactory.getLogger(SeatsPopulationAspect.class);

    @Autowired
    private LocRepository locRepository;

    @Autowired
    private ClasaRepository clasaRepository;

    @Around(value = "call(* com.flights.api.service.AvionService.add(com.flights.api.dto.CreateAvionDto, com.flights.api.model.MarcaAvion)) " +
            "&& args(avionDto, marcaAvion,..)", argNames = "proceedingJoinPoint,avionDto,marcaAvion")
    public Object populate(ProceedingJoinPoint proceedingJoinPoint, CreateAvionDto avionDto, MarcaAvion marcaAvion) throws Throwable {

        Avion avion = (Avion) proceedingJoinPoint.proceed();

        logger.info("Populating seats for plane with brand name: " + marcaAvion.getNume());

        Clasa clasa = clasaRepository.findByDenumire(DENUMIRE_CLASA)
                .orElseThrow(() -> new RuntimeException("Class: " + DENUMIRE_CLASA + " not present"));

        List<Loc> locuri = IntStream.range(0, avionDto.getLocuriMaxime()).mapToObj(loc -> Loc.builder()
                .avion(avion)
                .nrLoc(loc)
                .clasa(clasa)
                .build())
                .collect(toList());

        locRepository.saveAll(locuri);

        return avion;
    }

    public static SeatsPopulationAspect aspectOf() {
        return SpringApplicationContextHolder.getApplicationContext().getBean(SeatsPopulationAspect.class);
    }
}
