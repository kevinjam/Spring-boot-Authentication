package com.kevin.Authentication.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {

    @GetMapping("/hello")
    fun hello() = "hello.html"

    @GetMapping("/main")
    fun main()= "main.html"

    @GetMapping("/admin")
    fun admin()= "admin.html"
}