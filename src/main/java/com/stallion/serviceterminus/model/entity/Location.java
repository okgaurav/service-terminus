package com.stallion.serviceterminus.model.entity;

import java.util.List;

public class Location {
    private Number days;
    private Number nights;
    private Number distance;
    private Number time;
    private List<Integer> places;

    public Number getDays() {
        return days;
    }

    public Location setDays(Number days) {
        this.days = days;
        return this;
    }

    public Number getNights() {
        return nights;
    }

    public Location setNights(Number nights) {
        this.nights = nights;
        return this;
    }

    public Number getDistance() {
        return distance;
    }

    public Location setDistance(Number distance) {
        this.distance = distance;
        return this;
    }

    public Number getTime() {
        return time;
    }

    public Location setTime(Number time) {
        this.time = time;
        return this;
    }

    public List<Integer> getPlaces() {
        return places;
    }

    public Location setPlaces(List<Integer> places) {
        this.places = places;
        return this;
    }

    @Override
    public String toString() {
        return "Location{" +
                "days=" + days +
                ", nights=" + nights +
                ", distance=" + distance +
                ", time=" + time +
                ", places=" + places +
                '}';
    }
}
