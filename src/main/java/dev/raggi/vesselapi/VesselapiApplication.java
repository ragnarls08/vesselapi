package dev.raggi.vesselapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"dev.raggi.vesselapi.controllers", "dev.raggi.services"})
@EntityScan("dev.raggi.models")
@EnableJpaRepositories("dev.raggi.repositories")
public class VesselapiApplication
{
    public static void main(String[] args) {
        SpringApplication.run(VesselapiApplication.class, args);
    }
}
