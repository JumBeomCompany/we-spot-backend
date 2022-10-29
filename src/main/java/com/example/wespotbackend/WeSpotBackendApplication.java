package com.example.wespotbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WeSpotBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeSpotBackendApplication.class, args);
    }

}
