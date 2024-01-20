package com.stallion.serviceterminus.service;


import com.stallion.serviceterminus.error.TerminusGenericException;
import com.stallion.serviceterminus.mapper.CruiseMapper;
import com.stallion.serviceterminus.model.api.CruiseRequestApiDto;
import com.stallion.serviceterminus.model.entity.Cruise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import com.stallion.serviceterminus.repository.CruiseRepository;

import java.time.LocalDate;
import java.time.LocalTime;

import static reactor.core.publisher.Mono.error;


@Service
public class CruiseService {

    private final CruiseRepository cruiseRepository;
    Logger logger = LoggerFactory.getLogger(CruiseService.class);

    public CruiseService(CruiseRepository cruiseRepository) {
        this.cruiseRepository = cruiseRepository;
    }

    public Mono<Cruise> save(CruiseRequestApiDto cruise){
        setDefaults(cruise);
        defaultValidation(cruise);
        return cruiseRepository.save(CruiseMapper.toEntity(cruise))
                .doOnSubscribe(a-> logger.info("Cruise details saved successfully {}",a))
                .switchIfEmpty(errorWhileSavingData());
    }

    public Mono<Cruise> getById(String id){
        return cruiseRepository.findById(id)
                .doOnSubscribe(a-> logger.info("Fetching details of cruise for id = {}",id))
                .switchIfEmpty(error(new TerminusGenericException("No cruise available for id = "+id)))
                .doOnSuccess(a-> logger.info("Fetching cruise successful "+a));
    }

    private void setDefaults(CruiseRequestApiDto cruise){
        if(cruise.getStartingTime()==null)
            cruise.setStartingTime(LocalTime.of(0,0));
    }

    private void defaultValidation(CruiseRequestApiDto cruise){
        validateStaringDate(cruise);
    }

    private void validateStaringDate(CruiseRequestApiDto cruiseRequestApiDto){
        if(cruiseRequestApiDto.getStartingDate().isBefore(LocalDate.now()))
            throw new TerminusGenericException("Starting date must be a future date");
    }

    private Mono<Cruise> errorWhileSavingData(){
         return error(new TerminusGenericException("Error while saving data"));
    }

}
