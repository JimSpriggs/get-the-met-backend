package uk.spon.getthemet.service;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(MetrolinkStationServiceProperties.class)
public class MetrolinkStationService {
    private MetrolinkStationServiceProperties metrolinkStationServiceProperties;

    public MetrolinkStationService(MetrolinkStationServiceProperties metrolinkStationServiceProperties) {
        this.metrolinkStationServiceProperties = metrolinkStationServiceProperties;
    }

    public String name() {
        return metrolinkStationServiceProperties.getName();
    }
}
