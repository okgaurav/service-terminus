package com.stallion.serviceterminus.model.entity;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class Terminal {
    @Id
    private String terminalId;
    private String source;
    private String destination;
    private Number distance;
    private Medium medium;
    private TravelType Type;
    private LocalDateTime operationStart;
    private LocalDateTime operationClosure;

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

    public LocalDateTime getOperationStart() {
        return operationStart;
    }

    public Terminal setOperationStart(LocalDateTime operationStart) {
        this.operationStart = operationStart;
        return this;
    }

    public LocalDateTime getOperationClosure() {
        return operationClosure;
    }

    public Terminal setOperationClosure(LocalDateTime operationClosure) {
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
