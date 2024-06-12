package de.suprize.springcoredemo.rest;

import de.suprize.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private final Coach coach;
    private final Coach anotherCoach;

    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") final Coach coach,
            @Qualifier("cricketCoach") final Coach anotherCoach
    ) {
        System.out.println("In constructor: " + this.getClass().getSimpleName());
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return coach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == anotherCoach, " + (this.coach == this.anotherCoach);
    }

}
