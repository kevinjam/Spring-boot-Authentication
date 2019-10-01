package com.kevinjanvier.springsecuritydemo.security

import org.springframework.security.crypto.password.PasswordEncoder

//its an object

class PlainTextPasswordEncoder : PasswordEncoder{
    override fun encode(rawPassword: CharSequence?): String {
        return rawPassword.toString()
    }

    override fun matches(rawPassword: CharSequence?, encodedPassword: String?): Boolean {

        return rawPassword.toString().equals(encodedPassword)
    }
}