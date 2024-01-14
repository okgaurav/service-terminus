package com.stallion.serviceterminus.model.entity;

import java.time.OffsetDateTime;

public class Terminal {
    private String terminalId;
    private String source;
    private String destination;
    private Number distance;
    private Medium medium;
    private TravelType Type;
    private OffsetDateTime operationStart;
    private OffsetDateTime operationClosure;

    public String getTerminalId() {
        return terminalId;
    }

    public Terminal setTerminalId(String terminalId) {
        this.terminalId = terminalId;
        return this;
    }

    public String getSource() {
        return source;
    }

    public Terminal setSource(String source) {
        this.source = source;
        return this;
    }

    public String getDestination() {
        return destination;
    }

    public Terminal setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public Medium getMedium() {
        return medium;
    }

    public Terminal setMedium(Medium medium) {
        this.medium = medium;
        return this;
    }

    public TravelType getType() {
        return Type;
    }

    public Terminal setType(TravelType type) {
        Type = type;
        return this;
    }

    public OffsetDateTime getOperationStart() {
        return operationStart;
    }

    public Terminal setOperationStart(OffsetDateTime operationStart) {
        this.operationStart = operationStart;
        return this;
    }

    public OffsetDateTime getOperationClosure() {
        return operationClosure;
    }

    public Terminal setOperationClosure(OffsetDateTime operationClosure) {
        this.operationClosure = operationClosure;
        return this;
    }

    public Number getDistance() {
        return distance;
    }

    public Terminal setDistance(Number distance) {
        this.distance = distance;
        return this;
    }
}
