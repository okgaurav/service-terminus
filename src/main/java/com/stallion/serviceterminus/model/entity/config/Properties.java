package com.stallion.serviceterminus.model.entity.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "authorization")
@EnableConfigurationProperties
public class Properties {
    private HashMap<String, List<String>> permission;

    public HashMap<String, List<String>> getPermission() {
        return permission;
    }

    public Properties setPermission(HashMap<String, List<String>> permission) {
        this.permission = permission;
        return this;
    }
}
