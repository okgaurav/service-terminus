package com.stallion.serviceterminus.model.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "stallion.default")
@EnableConfigurationProperties
public class TerminusCode {
    Map<String, Map<String, City>> placesCodes;

    public Map<String, Map<String, City>> getPlacesCodes() {
        return placesCodes;
    }

    public TerminusCode setPlacesCodes(Map<String, Map<String, City>> placesCodes) {
        this.placesCodes = placesCodes;
        return this;
    }
}
