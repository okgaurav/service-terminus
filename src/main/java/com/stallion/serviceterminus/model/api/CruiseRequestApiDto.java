package com.stallion.serviceterminus.model.api;

import jakarta.validation.constraints.NotNull;
import com.stallion.serviceterminus.model.entity.Terminal;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class CruiseRequestApiDto {

    private String cruiseId;
    @NotNull
    private String source;
    @NotNull
    private String destination;
    private List<Terminal> terminalList;
    @NotNull
    private LocalDate startingDate;
    private LocalTime startingTime;
    private LocalDateTime closureDateTime;
    @NotNull
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

    public List<Terminal> getTerminalList() {
        return terminalList;
    }

    public CruiseRequestApiDto setTerminalList(List<Terminal> terminalList) {
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
