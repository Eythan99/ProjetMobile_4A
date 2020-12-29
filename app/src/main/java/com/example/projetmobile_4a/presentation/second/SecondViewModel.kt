package com.example.projetmobile_4a.presentation.second

import androidx.lifecycle.ViewModel
import com.example.projetmobile_4a.data.remote.model.Weather
import com.example.projetmobile_4a.domain.usecase.GetUserUseCase
import kotlin.properties.Delegates

class SecondViewModel (
        private val getUserUseCase: GetUserUseCase
) : ViewModel(){
}