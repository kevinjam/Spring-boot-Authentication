package com.kevin.Authentication.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class WelcomeController {


    @GetMapping("/welcome")
    fun welcome() = "welcome.html"
}