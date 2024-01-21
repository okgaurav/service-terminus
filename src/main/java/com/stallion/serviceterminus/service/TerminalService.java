package com.stallion.serviceterminus.service;

import com.stallion.serviceterminus.error.TerminusGenericException;
import com.stallion.serviceterminus.mapper.TerminalMapper;
import com.stallion.serviceterminus.model.api.CruiseRequestApiDto;
import com.stallion.serviceterminus.model.api.TerminalRequestApiDto;
import com.stallion.serviceterminus.model.entity.Cruise;
import com.stallion.serviceterminus.utils.MapperUtils;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.stallion.serviceterminus.mapper.CruiseMapper.toApi;
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
        validateRequest(terminal);
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

    //Todo Drop terminal code will be refactored and terminal will be saved in sds
    //TODO Check 1 : While Adding a Terminal, make sure It align with previous Terminal and next Terminal
    //TODO Check 2 : While Deleting a Terminal, make sure It align with previous Terminal and next Terminal

    private Mono<CruiseRequestApiDto> dropFromList(CruiseRequestApiDto cruise, String terminalId){
        logger.info("Dropping terminal with id "+terminalId);
        return just(cruise.setTerminalList(cruise.getTerminalList().stream().filter(apiDto -> !Objects.equals(apiDto.getTerminalId(), terminalId)).collect(Collectors.toList())));
    }

    private void validateRequest(TerminalRequestApiDto apiDto){
        validateStaringDate(apiDto);
    }

    private void validateStaringDate(TerminalRequestApiDto apiDto){
        if(apiDto.getStartingDate().isBefore(LocalDate.now()))
            throw new TerminusGenericException("Starting date must be a future date");
    }
    private TerminalRequestApiDto setDefaults(TerminalRequestApiDto apiDto){
        if(apiDto.getStartingTime()==null)
            apiDto.setStartingTime(LocalTime.of(0,0));
        return apiDto.setTerminalId(ObjectId.get().toHexString());
    }

    public Mono<Object> dropTerminal(String id, String terminalId) {
        return cruiseService.getById(id)
                .flatMap(a -> dropFromList(toApi(a), terminalId))
                .flatMap(cruiseService::save)
                .map(a-> terminalId);
    }
}
