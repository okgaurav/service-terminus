package com.stallion.serviceterminus.resource;

import com.stallion.serviceterminus.model.api.CruiseRequestApiDto;
import com.stallion.serviceterminus.model.api.TerminalRequestApiDto;
import com.stallion.serviceterminus.model.entity.config.Distance;
import com.stallion.serviceterminus.model.entity.config.TerminusCode;
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

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


@RestController
@Validated
@RequestMapping("/cruise")
public class CruiseResource {
    private final CruiseService cruiseService;
    private final TerminalService terminalService;
    private final Distance distance;
    private final TerminusCode terminusCode;

    public CruiseResource(CruiseService cruiseService, TerminalService terminalService, Distance distance, TerminusCode terminusCode) {
        this.cruiseService = cruiseService;
        this.terminalService = terminalService;
        this.distance = distance;
        this.terminusCode = terminusCode;
    }

    @PostMapping
    Mono<ResponseEntity<Object>> create(@Valid @RequestBody CruiseRequestApiDto apiDto) {
        return cruiseService.save(apiDto).map(CruiseMapper::toApi)
                .map(o -> StallionResponseHandler.responseBuilder("Created an instance", CREATED, o));
    }

    @GetMapping("/{id}")
    Mono<ResponseEntity<Object>> getById(@PathVariable String id) {
        return cruiseService.getById(id).map(CruiseMapper::toApi)
                .map(o -> StallionResponseHandler.responseBuilder("Instance fetched", OK, o));
    }

    @GetMapping("/{id}/terminals")
    ResponseEntity<Flux<TerminalRequestApiDto>> getByAccountId(@PathVariable String id) {
        return ResponseEntity.ok(terminalService.getTerminalByAccountId(id));
    }

    @PatchMapping("/{id}/terminals")
    Mono<ResponseEntity<Object>> setTerminal(@PathVariable String id, @RequestBody TerminalRequestApiDto terminal) {
        return terminalService.addTerminalByAccountId(terminal, id)
                .map(o -> StallionResponseHandler.responseBuilder("Instance saved in list", OK, o));
    }

    @DeleteMapping("/{id}/terminals/{terminalId}")
    Mono<ResponseEntity<Object>> dropTerminal(@PathVariable String id, @PathVariable String terminalId) {
        return terminalService.dropTerminal(id, terminalId)
                .map(o -> StallionResponseHandler.responseBuilder("Instance removed from list", OK, o));
    }

    @GetMapping
    public List<String> properties() {
        return terminusCode.getActualRoutes("DL", "SPV").getRoute().stream()
                .map(a -> terminusCode.getPlacesCodes().get(a.intValue()).getTitle()).collect(Collectors.toList());
    }
}
