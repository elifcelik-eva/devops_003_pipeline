package com.elifcelik.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping
public class DevOpsController {

    @GetMapping
    public String devopsHello(){
        return "DevOps Pipeline " + "Date: " + LocalDateTime.now();
    }

    @GetMapping("info")
    public String info(){
        return "Info  " + "Date: " + LocalDateTime.now();
    }
}
