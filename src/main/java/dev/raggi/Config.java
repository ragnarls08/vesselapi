package dev.raggi;

import dev.raggi.services.*;
import dev.raggi.vesselapi.controllers.PositionController;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    PositionController positionController(@Qualifier("positionService") IPositionService positionService) {
        return new PositionController(positionService);
    }

    @Bean
    IPositionService positionService() {
        return new PositionService();
    }


}