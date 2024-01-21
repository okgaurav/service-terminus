package com.stallion.serviceterminus.model.entity.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
@ConfigurationProperties(prefix = "stallion.default")
@EnableConfigurationProperties
public class TerminusCode {
   Map<Integer, City> placesCodes;
   Map<String, Map<String, RoutePlan>> routes;

   Map<String,Integer> motorCodes;

   public Map<Integer, City> getPlacesCodes() {
      return placesCodes;
   }

   public TerminusCode setPlacesCodes(Map<Integer, City> placesCodes) {
      this.placesCodes = placesCodes;
      return this;
   }

   public Map<String, Map<String, RoutePlan>> getRoutes() {
      return routes;
   }

   public TerminusCode setRoutes(Map<String, Map<String, RoutePlan>> routes) {
      this.routes = routes;
      return this;
   }

   public Map<String, Integer> getMotorCodes() {
      return motorCodes;
   }

   public TerminusCode setMotorCodes(Map<String, Integer> motorCodes) {
      this.motorCodes = motorCodes;
      return this;
   }

   public RoutePlan getActualRoutes(String from, String to){
      return this.getRoutes().get(from).get(to);
   }
}
