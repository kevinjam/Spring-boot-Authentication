package com.kevin.Authentication.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider
import org.springframework.security.oauth2.client.registration.ClientRegistration
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository

@Configuration
class ProjectConfig : WebSecurityConfigurerAdapter() {


    @Bean
    fun clientRegistrationRepository():ClientRegistrationRepository {
        val c = clientReg()
        return  InMemoryClientRegistrationRepository(c)
    }


    override fun configure(http: HttpSecurity?) {
        http!!.oauth2Login()
        http.authorizeRequests()
                .anyRequest().authenticated()
    }

    private fun  clientReg():ClientRegistration{
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .clientId("Iv1.164d571d6b996fa4")
                .clientSecret("26383db128fcd4c1f305c84462a248e1fa31241f")
                .build()

    }
}