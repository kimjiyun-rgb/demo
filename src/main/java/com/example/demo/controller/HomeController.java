package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // <-- pom.xml lombok <dependency>
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String home() {
        log.trace("trace!");
        log.debug("debug!");
        log.info("info!");
        log.warn("warn!");
        log.error("error!");
        return "Home!!!!!!!";
    }

    @GetMapping("/store")
    // @ResponseBody
    public String store(Model model) {
        model.addAttribute("user_name", "스프링부트");
        model.addAttribute("score", 88.12);
        return "store"; // 파일명을 의미
    }

    @GetMapping("/store/json")
    @ResponseBody
    public Map<String, Object> storeJson() {
        // import java.util
        Map<String, Object> map = new HashMap<>();

        map.put("user_name", "스프링부트");
        map.put("score", 88.12);

        return map; // 파일명을 의미
    }
}
