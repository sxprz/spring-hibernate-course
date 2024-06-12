package de.suprize.springcoredemo.config;

import de.suprize.springcoredemo.common.Coach;
import de.suprize.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquaticCoach")
    public Coach swimCoach() {
        return new SwimCoach();
    }

}
