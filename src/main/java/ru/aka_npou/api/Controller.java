package ru.aka_npou.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/users/{id}")
    public String getUser(@PathVariable String id) {
        return "answer";
    }

    @RequestMapping("/locations/{id}")
    public String getLocation(@PathVariable String id) {
        return "answer";
    }

    @RequestMapping("/visits/{id}")
    public String getVisit(@PathVariable String id) {
        return "answer";
    }
}
