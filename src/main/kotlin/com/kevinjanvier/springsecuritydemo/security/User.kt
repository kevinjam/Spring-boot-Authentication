package com.kevinjanvier.springsecuritydemo.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

class User : UserDetails {

    private  var username= ""
    private var password =""
    
    constructor(username:String, password:String){
        this.username = username
        this.password = password

    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val list = mutableListOf<GrantedAuthority>()
        list.add(SimpleGrantedAuthority("ADMIN"))
        list.add(SimpleGrantedAuthority("USER"))

        return list

    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return username
    }

    override fun isCredentialsNonExpired(): Boolean {
return true    }

    override fun getPassword(): String {
return password   }

    override fun isAccountNonExpired(): Boolean {
return true    }

    override fun isAccountNonLocked(): Boolean {
return true    }
}