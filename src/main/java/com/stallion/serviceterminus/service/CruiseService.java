package com.stallion.serviceterminus.service;


import com.stallion.serviceterminus.mapper.CruiseMapper;
import com.stallion.serviceterminus.model.api.CruiseRequestApiDto;
import com.stallion.serviceterminus.model.entity.Cruise;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import com.stallion.serviceterminus.repository.CruiseRepository;

import java.time.LocalTime;


@Service
public class CruiseService {

    private final CruiseRepository cruiseRepository;

    public CruiseService(CruiseRepository cruiseRepository) {
        this.cruiseRepository = cruiseRepository;
    }

    public Mono<Cruise> save(CruiseRequestApiDto cruise){
        return cruiseRepository.save(CruiseMapper.toEntity(setDefaults(cruise)));
    }
    private CruiseRequestApiDto setDefaults(CruiseRequestApiDto cruise){
        if(cruise.getStartingTime()==null)
            cruise.setStartingTime(LocalTime.of(0,0));
        return cruise;
    }
}
