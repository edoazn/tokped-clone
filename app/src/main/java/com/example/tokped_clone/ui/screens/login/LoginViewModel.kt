package com.example.tokped_clone.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tokped_clone.data.request.UserRequest
import com.example.tokped_clone.data.response.UserResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel : ViewModel() {

    private val repository = LoginRepository()

    // State untuk view
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    // Fungsi untuk melakukan login
    fun doLogin(username: String, password: String) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            try {
                val response = repository.login(UserRequest(username, password))
                if (response.isSuccessful) {
                    val userData = response.body() ?: throw Exception("Data tidak ditemukan")
                    _loginState.value = LoginState.Success(userData)
                } else {
                    throw Exception("Login Gagal: ${response.message()}")
                }


            } catch (e: Exception) {
                _loginState.value = LoginState.Error(e.localizedMessage ?: "Terjadi Kesalahan")
            }
        }
    }
}
