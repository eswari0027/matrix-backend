package com.matrix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("welcomeMessage", "Matrix Globe Tech");
        return "index"; // must match template name in src/main/resources/templates/index.html
    }
}
