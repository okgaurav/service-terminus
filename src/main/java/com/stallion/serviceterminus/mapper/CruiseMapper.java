package com.stallion.serviceterminus.mapper;



import com.stallion.serviceterminus.model.api.CruiseRequestApiDto;
import com.stallion.serviceterminus.model.entity.Cruise;
import com.stallion.serviceterminus.utils.MapperUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CruiseMapper {
    public static Cruise toEntity(CruiseRequestApiDto apiDto){
        apiDto.getTerminalList().stream().forEach(TerminalMapper::toEntity);
        return new Cruise()
                .setCruiseId(apiDto.getCruiseId())
                .setClosureDateTime(apiDto.getClosureDateTime())
                .setDestination(apiDto.getDestination())
                .setSource(apiDto.getSource())
                .setEntryDateTime(LocalDateTime.now())
                .setTotalPassengers(apiDto.getTotalPassengers())
                .setStaringDateTime(toDateTime(apiDto.getStartingDate(), apiDto.getStartingTime()))
                .setTerminalList(MapperUtils.mapListIfNotNull(TerminalMapper::toEntity, apiDto.getTerminalList()));
    }

    public static CruiseRequestApiDto toApi(Cruise cruise){
        return new CruiseRequestApiDto()
                .setCruiseId(cruise.getCruiseId())
                .setSource(cruise.getSource())
                .setDestination(cruise.getDestination())
                .setTerminalList(MapperUtils.mapListIfNotNull(TerminalMapper::toApi, cruise.getTerminalList()))
                .setTotalPassengers(cruise.getTotalPassengers())
                .setStartingDate(cruise.getStaringDateTime().toLocalDate())
                .setStartingTime(cruise.getStaringDateTime().toLocalTime())
                .setClosureDateTime(cruise.getClosureDateTime());
    }

    private static LocalDateTime toDateTime(LocalDate date, LocalTime time){
        return LocalDateTime.of(date, time);
    }

}