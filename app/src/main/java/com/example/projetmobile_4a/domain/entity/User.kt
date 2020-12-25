package com.example.projetmobile_4a.domain.entity

import java.io.Serializable

data class User(
        var email: String,
        val password: String,
        val nom: String,
        val prenom: String
) : Serializable