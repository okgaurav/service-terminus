package com.stallion.serviceterminus.mapper;

import com.stallion.serviceterminus.model.api.TerminalRequestApiDto;
import com.stallion.serviceterminus.model.entity.Terminal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TerminalMapper {

    public static Terminal toEntity(TerminalRequestApiDto apiDto){
        return new Terminal()
                .setDestination(apiDto.getDestination())
                .setSource(apiDto.getSource())
                .setTerminalId(apiDto.getTerminalId())
                .setDistance(0)
                .setMedium(apiDto.getMedium())
                .setType(apiDto.getType())
                .setOperationStart(toDateTime(apiDto.getStartingDate(), apiDto.getStartingTime()))
                .setOperationClosure(apiDto.getOperationClosure());
    }

    public static TerminalRequestApiDto toApi(Terminal terminal){
        return new TerminalRequestApiDto()
                .setDestination(terminal.getDestination())
                .setStartingTime(terminal.getOperationStart().toLocalTime())
                .setStartingDate(terminal.getOperationStart().toLocalDate())
                .setMedium(terminal.getMedium())
                .setTerminalId(terminal.getTerminalId())
                .setOperationClosure(terminal.getOperationClosure())
                .setType(terminal.getType())
                .setSource(terminal.getSource());
    }

    private static LocalDateTime toDateTime(LocalDate date, LocalTime time){
        return LocalDateTime.of(date, time);
    }

}
