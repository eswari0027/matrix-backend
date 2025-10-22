package com.matrix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test") // unique base path
public class TestController {

    @GetMapping("/health")
    public String health() {
        return "✅ TestController is running!";
    }
}
