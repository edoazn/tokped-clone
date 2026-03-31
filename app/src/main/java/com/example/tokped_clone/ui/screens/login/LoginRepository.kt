package com.example.tokped_clone.ui.screens.login

import com.example.tokped_clone.data.network.ApiConfig
import com.example.tokped_clone.data.request.UserRequest

class LoginRepository {
    private val apiService = ApiConfig().apiService

    // fungsi untuk melakukan login
    suspend fun login(request: UserRequest) = apiService.login(request)
}