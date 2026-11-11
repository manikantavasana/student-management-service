package com.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpaController {

    @GetMapping({"/students", "/courses"})
    public String showApplication() {
        return "forward:/index.html";
    }
}
