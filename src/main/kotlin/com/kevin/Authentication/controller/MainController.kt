package com.kevin.Authentication.controller

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {


    @GetMapping("/")
    fun home(user:OAuth2AuthenticationToken):String{

        println("UserDetails From Git $user")
        return "home.html"
    }


}