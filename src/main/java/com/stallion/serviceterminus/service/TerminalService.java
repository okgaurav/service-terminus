package com.stallion.serviceterminus.service;

import com.stallion.serviceterminus.error.TerminusGenericException;
import com.stallion.serviceterminus.mapper.CruiseMapper;
import com.stallion.serviceterminus.mapper.TerminalMapper;
import com.stallion.serviceterminus.model.api.CruiseRequestApiDto;
import com.stallion.serviceterminus.model.api.TerminalRequestApiDto;
import com.stallion.serviceterminus.model.entity.Cruise;
import com.stallion.serviceterminus.model.entity.Terminal;
import com.stallion.serviceterminus.utils.MapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.stallion.serviceterminus.mapper.CruiseMapper.toApi;
import static com.stallion.serviceterminus.mapper.CruiseMapper.toEntity;
import static reactor.core.publisher.Mono.error;
import static reactor.core.publisher.Mono.just;

@Service
public class TerminalService {

    private final CruiseService cruiseService;
    Logger logger = LoggerFactory.getLogger(TerminalService.class);


    public TerminalService(CruiseService cruiseService) {
        this.cruiseService = cruiseService;
    }

    public Flux<TerminalRequestApiDto> getTerminalByAccountId(String id){
        return cruiseService.getById(id)
                .map(Cruise::getTerminalList)
                .map(a-> MapperUtils.mapListIfNotNull(TerminalMapper::toApi, a))
                .flatMapMany(Flux::fromIterable)
                .doOnSubscribe(a-> logger.info("Fetching terminals available for id {}",id));
    }

    public Mono<TerminalRequestApiDto> addTerminalByAccountId(TerminalRequestApiDto terminal, String id){
        return cruiseService.getById(id)
                .flatMap(a-> addToList(setDefaults(terminal), toApi(a), Optional.ofNullable(terminal.getPosition())))
                .flatMap(cruiseService::save)
                .map(a-> terminal);
    }

    private Mono<CruiseRequestApiDto> addToList(TerminalRequestApiDto terminal, CruiseRequestApiDto cruise, Optional<Number> pos){
        List<TerminalRequestApiDto> terminals = cruise.getTerminalList();
        if(pos.isPresent())
            terminals.add(pos.get().intValue(), terminal);
        else
            terminals.add(terminal);
        return just(cruise).map(a-> a.setTerminalList(terminals));
    }
    private TerminalRequestApiDto setDefaults(TerminalRequestApiDto apiDto){
        if(apiDto.getStartingTime()==null)
            apiDto.setStartingTime(LocalTime.of(0,0));
        return apiDto;
    }

}
