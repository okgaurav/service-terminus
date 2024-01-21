package com.stallion.serviceterminus.model.entity.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "distance")
@EnableConfigurationProperties
public class Distance {
    Map<String, Map<String, Location>> origin;

    public Map<String, Map<String, Location>> getOrigin() {
        return origin;
    }

    public Distance setOrigin(Map<String, Map<String, Location>> origin) {
        this.origin = origin;
        return this;
    }
    public Map<String, Location> getDelhiOrigin(){
        return origin.get("DL");
    }
    public Location getLocationDetails(String originCode, String destinationCode){
        return this.getOrigin().get(originCode).get(destinationCode);
    }
}
