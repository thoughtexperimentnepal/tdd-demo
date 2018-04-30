package com.example.tdddemo.controller;

import com.example.tdddemo.service.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetingsController {

    @Autowired
    GreetingsService greetingsService;

    @GetMapping("/greeting")
    public ResponseEntity<String> greetings(
            @RequestParam("name")String name,
            @RequestParam("gender")String gender
    ){
        String salute = greetingsService.getGreetingByGender(gender);

        return new ResponseEntity<>(
                String.format("Hello %s %s. How are you?",salute, name),
                HttpStatus.OK
        );
    }
}
