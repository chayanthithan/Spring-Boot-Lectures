package com.example.Render.sample.App.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/renderservice")
public class RenderController {
    @GetMapping("/login")
    public String LoginController(@RequestParam String userName){
        return "successfully logged by"+userName;
    }
}
