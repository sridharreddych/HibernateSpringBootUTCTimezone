package com.app;

import com.app.service.ScreenshotService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final ScreenshotService screenshotService;

    public MainApplication(ScreenshotService screenshotService) {
        this.screenshotService = screenshotService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            screenshotService.saveScreenshotInUTC();
            screenshotService.displayScreenshotInUTC();
        };
    }

}

/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * UTC Timezone And MySQL

Description: This application is a sample of how to store date, time, and timestamps in UTC time zone. The second setting, useLegacyDatetimeCode is needed only for MySQL. Otherwise, set only hibernate.jdbc.time_zone.

Key points:

spring.jpa.properties.hibernate.jdbc.time_zone=UTC
spring.datasource.url=jdbc:mysql://localhost:3306/screenshotdb?useLegacyDatetimeCode=false
*/
