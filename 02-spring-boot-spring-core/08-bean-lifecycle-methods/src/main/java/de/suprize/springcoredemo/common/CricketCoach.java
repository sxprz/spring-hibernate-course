package de.suprize.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + this.getClass().getSimpleName());
    }

    // define init method
    @PostConstruct
    public void postConstruct() {
        System.out.println("In postConstruct(): " + this.getClass().getSimpleName());
    }

    // define destroy method
    @PreDestroy
    public void preDestroy() {
        System.out.println("In preDestroy(): " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

}
