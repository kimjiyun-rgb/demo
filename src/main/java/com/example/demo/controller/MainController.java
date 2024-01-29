package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/main")
    @ResponseBody
    public String home() {
        return "Home!!!!!!!";
    }

    @GetMapping("/main/store")
    @ResponseBody
    public String store() {
        return "Store";
    }
}
