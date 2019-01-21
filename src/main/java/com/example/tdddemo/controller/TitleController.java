package com.example.tdddemo.controller;

import com.example.tdddemo.service.TitleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TitleController {

    TitleService titleService;

    public TitleController(TitleService titleService){
        this.titleService = titleService;
    }

    @GetMapping("/status/{id}")
    public String titleStatus(@PathVariable("id")Integer id ){
        Boolean status = titleService.getStatus(id);
        return String.valueOf(status);
    }
}
