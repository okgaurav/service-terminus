package com.stallion.serviceterminus.model.api;

import com.stallion.serviceterminus.model.entity.Medium;
import com.stallion.serviceterminus.model.entity.TravelType;

import java.time.OffsetDateTime;

public class TerminalRequestApiDto {
    private String terminalId;
    private String source;
    private String destination;
    private Medium medium;
    private TravelType Type;
    private OffsetDateTime operationStart;
    private OffsetDateTime operationClosure;

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

    public OffsetDateTime getOperationStart() {
        return operationStart;
    }

    public TerminalRequestApiDto setOperationStart(OffsetDateTime operationStart) {
        this.operationStart = operationStart;
        return this;
    }

    public OffsetDateTime getOperationClosure() {
        return operationClosure;
    }

    public TerminalRequestApiDto setOperationClosure(OffsetDateTime operationClosure) {
        this.operationClosure = operationClosure;
        return this;
    }
}
