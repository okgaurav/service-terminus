package com.stallion.serviceterminus.resource;

import com.stallion.serviceterminus.model.api.CruiseRequestApiDto;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import com.stallion.serviceterminus.mapper.CruiseMapper;
import com.stallion.serviceterminus.service.CruiseService;


@RestController
@Validated
@RequestMapping("/cruise")
public class CruiseResource {
    private final CruiseService cruiseService;

    public CruiseResource(CruiseService cruiseService) {
        this.cruiseService = cruiseService;
    }

    @PostMapping
    Mono<CruiseRequestApiDto> create(@Valid @RequestBody CruiseRequestApiDto apiDto){
        return cruiseService.save(apiDto).map(CruiseMapper::toApi);
    }
}
