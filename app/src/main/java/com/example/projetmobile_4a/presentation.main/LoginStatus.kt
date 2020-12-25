package com.example.projetmobile_4a.presentation.main

import com.example.projetmobile_4a.domain.entity.User

sealed class LoginStatus

data class LoginSuccess(val email: String, val password: String, val user: User) : LoginStatus()
object LoginError : LoginStatus()
