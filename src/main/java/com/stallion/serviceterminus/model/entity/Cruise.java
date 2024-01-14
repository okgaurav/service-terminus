package com.stallion.serviceterminus.model.entity;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public class Cruise {
    @Id
    private String cruiseId;
    private String source;
    @NotNull
    private String destination;
    private Number distance;
    private List<Terminal> terminalList;
    private LocalDateTime staringDateTime;
    private LocalDateTime closureDateTime;
    private LocalDateTime entryDateTime;

    private Number totalPassengers;

    public String getCruiseId() {
        return cruiseId;
    }

    public Cruise setCruiseId(String cruiseId) {
        this.cruiseId = cruiseId;
        return this;
    }

    public String getSource() {
        return source;
    }

    public Cruise setSource(String source) {
        this.source = source;
        return this;
    }

    public String getDestination() {
        return destination;
    }

    public Cruise setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public List<Terminal> getTerminalList() {
        return terminalList;
    }

    public Cruise setTerminalList(List<Terminal> terminalList) {
        this.terminalList = terminalList;
        return this;
    }


    public Number getTotalPassengers() {
        return totalPassengers;
    }

    public Cruise setTotalPassengers(Number totalPassengers) {
        this.totalPassengers = totalPassengers;
        return this;
    }

    public Number getDistance() {
        return distance;
    }

    public Cruise setDistance(Number distance) {
        this.distance = distance;
        return this;
    }

    public LocalDateTime getStaringDateTime() {
        return staringDateTime;
    }

    public Cruise setStaringDateTime(LocalDateTime staringDateTime) {
        this.staringDateTime = staringDateTime;
        return this;
    }

    public LocalDateTime getClosureDateTime() {
        return closureDateTime;
    }

    public Cruise setClosureDateTime(LocalDateTime closureDateTime) {
        this.closureDateTime = closureDateTime;
        return this;
    }

    public LocalDateTime getEntryDateTime() {
        return entryDateTime;
    }

    public Cruise setEntryDateTime(LocalDateTime entryDateTime) {
        this.entryDateTime = entryDateTime;
        return this;
    }
}
