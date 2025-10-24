package com.matrix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class FrontendController {

    @GetMapping({"/", "/Matrixglobetech"})
    public String home(Model model) {
        model.addAttribute("welcomeMessage", "Matrix Globe Tech");
        return "matrixgloltech/index";
    }

}
