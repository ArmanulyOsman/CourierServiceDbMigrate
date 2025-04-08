package com.example.courierservicedbmigrate;

import com.example.courierservicedbmigrate.service.MigrateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class CourierServiceDbMigrateApplication {

    private final MigrateService migrateService;


    public CourierServiceDbMigrateApplication(MigrateService migrateService) {
        this.migrateService = migrateService;
    }
    public static void main(String[] args) {
        SpringApplication.run(CourierServiceDbMigrateApplication.class, args);
    }

    @Bean
    ApplicationRunner init() {
        return args -> {
            var notifications = migrateService.readNotification();
            migrateService.writeInsertsToFile(notifications);
        };
    }
}
