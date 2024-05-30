package de.sxprz.springboot.course.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomRestController {

    // expose '/' returning "Welcome to my demo project!"
    @GetMapping
    public String sayHello() {
        return "Hello World";
    }

}
