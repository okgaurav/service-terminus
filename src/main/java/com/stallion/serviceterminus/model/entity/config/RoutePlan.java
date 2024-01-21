package com.stallion.serviceterminus.model.entity.config;

import java.util.List;

public class RoutePlan {
    private List<Number> route;
    private List<Number> time;

    public List<Number> getRoute() {
        return route;
    }

    public RoutePlan setRoute(List<Number> route) {
        this.route = route;
        return this;
    }

    public List<Number> getTime() {
        return time;
    }

    public RoutePlan setTime(List<Number> time) {
        this.time = time;
        return this;
    }
}
