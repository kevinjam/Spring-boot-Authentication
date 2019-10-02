package com.kevin.Authentication.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.security.provisioning.UserDetailsManager
import javax.sql.DataSource

@Configuration
class ProjectConfig :WebSecurityConfigurerAdapter(){


//    @Autowired
//    private lateinit var datasource: DataSource

    @Bean
    fun passwordEncode() = NoOpPasswordEncoder.getInstance()

    //password and username
    @Bean
    fun userDetailsManager(dataSource: DataSource):UserDetailsManager{
        //persite the user into the db
        val manager = JdbcUserDetailsManager(dataSource)


        return manager

    }


    override fun configure(http: HttpSecurity?) {
        http!!.formLogin()
        http.authorizeRequests().anyRequest().authenticated()
    }

}