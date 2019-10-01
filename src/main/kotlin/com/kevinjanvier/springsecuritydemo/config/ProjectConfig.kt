package com.kevinjanvier.springsecuritydemo.config

import com.kevinjanvier.springsecuritydemo.security.AppUserDetailsManager
import com.kevinjanvier.springsecuritydemo.security.PlainTextPasswordEncoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.provisioning.UserDetailsManager

@Configuration
class ProjectConfig : WebSecurityConfigurerAdapter(){

    @Bean
    fun passwordEncoder():PasswordEncoder = PlainTextPasswordEncoder()

    @Bean
    fun userDetailsManager():UserDetailsManager{
        val manager = InMemoryUserDetailsManager()
        val user = User.withUsername("john")
                .password("12345").authorities("ADMIN")
                .build()
        manager.createUser(user)
        return manager
    }

    override fun configure(http: HttpSecurity?) {
        http!!.httpBasic()
        http.authorizeRequests().anyRequest().authenticated()
    }

}