package com.stallion.serviceterminus.model.api;

import com.mongodb.lang.Nullable;
import com.stallion.serviceterminus.model.entity.Medium;
import com.stallion.serviceterminus.model.entity.TravelType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.stallion.serviceterminus.model.ModelConstants.NULL_FIELD;

public class TerminalRequestApiDto {

    private String terminalId;

    @NotNull(message = NULL_FIELD)
    private String source;

    @NotNull(message = NULL_FIELD)
    private String destination;

    @NotNull(message = NULL_FIELD)
    private Medium medium;

    @NotNull(message = NULL_FIELD)
    private TravelType Type;

    @NotNull(message = NULL_FIELD)
    private LocalDate startingDate;
    private LocalTime startingTime;
    private LocalDateTime operationClosure;
    /*
    * position = N : insert at Nth position from beginning
    * position = null : insert at last position
    * */

    @Nullable
    private Number position;

    public String getTerminalId() {
        return terminalId;
    }

    public TerminalRequestApiDto setTerminalId(String terminalId) {
        this.terminalId = terminalId;
        return this;
    }

    public String getSource() {
        return source;
    }

    public TerminalRequestApiDto setSource(String source) {
        this.source = source;
        return this;
    }

    public String getDestination() {
        return destination;
    }

    public TerminalRequestApiDto setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public Medium getMedium() {
        return medium;
    }

    public TerminalRequestApiDto setMedium(Medium medium) {
        this.medium = medium;
        return this;
    }

    public TravelType getType() {
        return Type;
    }

    public TerminalRequestApiDto setType(TravelType type) {
        Type = type;
        return this;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public TerminalRequestApiDto setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
        return this;
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public TerminalRequestApiDto setStartingTime(LocalTime startingTime) {
        this.startingTime = startingTime;
        return this;
    }

    public LocalDateTime getOperationClosure() {
        return operationClosure;
    }

    public TerminalRequestApiDto setOperationClosure(LocalDateTime operationClosure) {
        this.operationClosure = operationClosure;
        return this;
    }

    @Nullable
    public Number getPosition() {
        return position;
    }

    public TerminalRequestApiDto setPosition(@Nullable Number position) {
        this.position = position;
        return this;
    }
}
