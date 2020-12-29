package com.example.projetmobile_4a.presentation.createAccount

sealed class AccountStatus

data class AccountSuccess(val email: String, val password: String, val nom: String, val prenom: String) : AccountStatus()
object AccountError : AccountStatus()