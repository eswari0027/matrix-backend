package com.matrix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/frontend")  // Add a prefix
public class FrontendController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("welcomeMessage", "Matrix Globe Tech");
        return "matrixgloltech/index";
    }
}
