package com.example.tokped_clone.ui.screens.login

import com.example.tokped_clone.data.response.UserResponse

sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    data class Success(val data: UserResponse) : LoginState()
    data class Error(val message: String) : LoginState()
}

