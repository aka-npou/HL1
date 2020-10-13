package ru.aka_npou.api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aka_npou.exception.Exception400;
import ru.aka_npou.exception.Exception404;
import ru.aka_npou.model.User;
import ru.aka_npou.service.UserService;
import ru.aka_npou.util.Util;

@RestController
public class Controller {

    final ResponseEntity<String> responseEntity200 = ResponseEntity.ok().build();
    final ResponseEntity<String> responseEntity400 = ResponseEntity.status(400).build();
    final ResponseEntity<String> responseEntity404 = ResponseEntity.status(404).build();

    @Autowired
    UserService service;

    @GetMapping
    @RequestMapping("/users/{id}")
    public String getUser(@PathVariable String id) {
        return "answer";
    }

    @GetMapping
    @RequestMapping("/locations/{id}")
    public String getLocation(@PathVariable String id) {
        return "answer";
    }

    @GetMapping
    @RequestMapping("/visits/{id}")
    public String getVisit(@PathVariable String id) {
        return "answer";
    }

    @PostMapping
    @RequestMapping("users/new")
    public ResponseEntity<String> newUser(@RequestBody String body) {
        System.out.println(body);

        try {
            User user = Util.getUser(body);
            service.save(user);
        } catch (Exception400 e) {
            return responseEntity400;
        } catch (Exception404 e) {
            return responseEntity404;
        }

        return responseEntity200;
    }
}
