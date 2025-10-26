package com.matrix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Redirect root "/" to "/home"
    @GetMapping("/")
    public String redirectRoot() {
        return "redirect:/home";
    }

    // Handle "/home"
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("companyName", "Matrix Globe Tech");
        // Add any model attributes if needed
        return "index";  // your main page template
    }
}
