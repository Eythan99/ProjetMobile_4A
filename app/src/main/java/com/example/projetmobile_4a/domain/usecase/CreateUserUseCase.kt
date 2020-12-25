package com.example.projetmobile_4a.domain.usecase

import com.example.projetmobile_4a.data.repository.UserRepository
import com.example.projetmobile_4a.domain.entity.User

class CreateUserUseCase(
    private val userRepository: UserRepository
) {
    fun invoke(user: User){
        userRepository.createUser(user)
    }
}