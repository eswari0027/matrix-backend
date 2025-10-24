package com.matrix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    // Change mapping to /frontend (or anything unique)
    @GetMapping("/frontend")
    public String home(Model model) {
        // Add any model attributes if needed
        return "matrixgloltech/index"; // your frontend template
    }
}
