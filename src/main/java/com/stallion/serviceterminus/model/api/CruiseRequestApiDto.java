package com.stallion.serviceterminus.model.api;

import jakarta.validation.constraints.NotNull;
import com.stallion.serviceterminus.model.entity.Terminal;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static com.stallion.serviceterminus.model.ModelConstants.NULL_FIELD;

public class CruiseRequestApiDto {

    private String cruiseId;
    @NotNull(message = NULL_FIELD)
    private String source;
    @NotNull(message = NULL_FIELD)
    private String destination;
    private List<TerminalRequestApiDto> terminalList;
    @NotNull(message = NULL_FIELD)
    private LocalDate startingDate;
    private LocalTime startingTime;
    private LocalDateTime closureDateTime;
    @NotNull(message = NULL_FIELD)
    private Number totalPassengers;

    public String getCruiseId() {
        return cruiseId;
    }

    public CruiseRequestApiDto setCruiseId(String cruiseId) {
        this.cruiseId = cruiseId;
        return this;
    }

    public String getSource() {
        return source;
    }

    public CruiseRequestApiDto setSource(String source) {
        this.source = source;
        return this;
    }

    public String getDestination() {
        return destination;
    }

    public CruiseRequestApiDto setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public List<TerminalRequestApiDto> getTerminalList() {
        return terminalList;
    }

    public CruiseRequestApiDto setTerminalList(List<TerminalRequestApiDto> terminalList) {
        this.terminalList = terminalList;
        return this;
    }

    public LocalDateTime getClosureDateTime() {
        return closureDateTime;
    }

    public CruiseRequestApiDto setClosureDateTime(LocalDateTime closureDateTime) {
        this.closureDateTime = closureDateTime;
        return this;
    }

    public Number getTotalPassengers() {
        return totalPassengers;
    }

    public CruiseRequestApiDto setTotalPassengers(Number totalPassengers) {
        this.totalPassengers = totalPassengers;
        return this;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public CruiseRequestApiDto setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
        return this;
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public CruiseRequestApiDto setStartingTime(LocalTime startingTime) {
        this.startingTime = startingTime;
        return this;
    }
}
