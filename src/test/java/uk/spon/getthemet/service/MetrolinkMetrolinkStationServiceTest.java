package uk.spon.getthemet.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest("station.service.name=Prestwich")
public class MetrolinkMetrolinkStationServiceTest {
    @Autowired
    private MetrolinkStationService underTest;

    @Test
    public void contextLoads() {
        assertThat(underTest.name()).isNotNull();
        assertThat(underTest.name()).isEqualTo("Prestwich");
    }

    @SpringBootApplication
    static class TestConfiguration {}
}