package uk.spon.getthemet.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("station.service")
public class MetrolinkStationServiceProperties {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
