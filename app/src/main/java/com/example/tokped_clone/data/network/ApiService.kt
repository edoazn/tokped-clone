package com.example.tokped_clone.data.network

import com.example.tokped_clone.data.request.UserRequest
import com.example.tokped_clone.data.response.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/auth/login")
    suspend fun login(
        @Body user: UserRequest
    ): Response<UserResponse>
}
