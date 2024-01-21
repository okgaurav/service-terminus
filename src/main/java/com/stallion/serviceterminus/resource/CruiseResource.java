package com.stallion.serviceterminus.resource;

import com.stallion.serviceterminus.model.api.CruiseRequestApiDto;
import com.stallion.serviceterminus.model.api.TerminalRequestApiDto;
import com.stallion.serviceterminus.model.entity.Terminal;
import com.stallion.serviceterminus.service.TerminalService;
import com.stallion.serviceterminus.utils.StallionResponseHandler;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.stallion.serviceterminus.mapper.CruiseMapper;
import com.stallion.serviceterminus.service.CruiseService;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


@RestController
@Validated
@RequestMapping("/cruise")
public class CruiseResource {
    private final CruiseService cruiseService;
    private final TerminalService terminalService;

    public CruiseResource(CruiseService cruiseService, TerminalService terminalService) {
        this.cruiseService = cruiseService;
        this.terminalService = terminalService;
    }

    @PostMapping
    Mono<ResponseEntity<Object>> create(@Valid @RequestBody CruiseRequestApiDto apiDto){
        return cruiseService.save(apiDto).map(CruiseMapper::toApi)
                .map(o-> StallionResponseHandler.responseBuilder("Created an instance", CREATED,o));
    }

    @GetMapping("/{id}")
    Mono<ResponseEntity<Object>> getById(@PathVariable String id){
        return cruiseService.getById(id).map(CruiseMapper::toApi)
                .map(o-> StallionResponseHandler.responseBuilder("Instance fetched", OK,o));
    }

    @GetMapping("/{id}/terminals")
    ResponseEntity<Flux<TerminalRequestApiDto>> getByAccountId(@PathVariable String id){
        return ResponseEntity.ok(terminalService.getTerminalByAccountId(id));
    }

    @PatchMapping("/{id}/terminals")
    Mono<ResponseEntity<Object>> setTerminal(@PathVariable String id, @RequestBody TerminalRequestApiDto terminal){
        return terminalService.addTerminalByAccountId(terminal,id)
                .map(o->  StallionResponseHandler.responseBuilder("Instance saved in list", OK,o));
    }
}
