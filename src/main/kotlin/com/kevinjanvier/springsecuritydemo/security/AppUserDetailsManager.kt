package com.kevinjanvier.springsecuritydemo.security

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.provisioning.UserDetailsManager

class AppUserDetailsManager : UserDetailsManager {

    private val users = ArrayList<UserDetails>()
    override fun userExists(username: String?): Boolean {
        return users.stream().filter { u-> u.username == username }
                .findFirst()
                .isPresent

    }

    override fun updateUser(user: UserDetails?) {
    }


    override fun loadUserByUsername(username: String?): UserDetails {

        return users.stream()
                .filter { user->user.username == username}
                .findFirst()
                .orElse(null)
    }

    override fun createUser(user: UserDetails?) {
        users.add(user!!)
    }

    override fun deleteUser(username: String?) {
    }

    override fun changePassword(oldPassword: String?, newPassword: String?) {
    }
}