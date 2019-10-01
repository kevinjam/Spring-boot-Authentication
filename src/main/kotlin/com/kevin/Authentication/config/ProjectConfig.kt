package com.kevin.Authentication.config

import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.provisioning.UserDetailsManager

@Configuration
class ProjectConfig : WebSecurityConfigurerAdapter() {

    @Bean
    fun passwordEncode() = NoOpPasswordEncoder.getInstance()

    @Bean
    fun userDetailManager():UserDetailsManager{
        val manager = InMemoryUserDetailsManager()
        val user = User.withUsername("admin")
                .password("12345")
                .authorities("ADMIN")
                .build()


        val user2 = User.withUsername("bill")
                .password("12345")
                .authorities("USER")
                .build()
        manager.createUser(user)
        manager.createUser(user2)
        return manager
    }

    override fun configure(http: HttpSecurity?) {
        http!!.formLogin()
                .defaultSuccessUrl("/hello", true)

        http.authorizeRequests()
                .mvcMatchers("/admin")
                .access("hasAnyAuthority('ADMIN')")
                .mvcMatchers("/main").permitAll()
                .anyRequest().authenticated()




    }
}