package com.example.tokped_clone.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tokped_clone.R
import com.example.tokped_clone.ui.theme.Tokped_cloneTheme

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel()
) {
    val loginState by viewModel.loginState.collectAsState()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 54.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Container utama
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFEFEFEF), shape = MaterialTheme.shapes.medium)
                .padding(start = 32.dp, top = 32.dp, end = 32.dp, bottom = 8.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Column {
                // Text Header
                Text(
                    text = stringResource(R.string.masuk),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding()
                )
                // Text Body
                Text(
                    text = stringResource(R.string.login_body_txt) +
                            "penjelajahan.",
                    fontSize = 14.sp,
                    color = Color.Gray,
                )
                Spacer(modifier = Modifier.height(32.dp))
                // Text email
                Text(
                    text = stringResource(R.string.text_email),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                // Email Input
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(
                            "Contoh: email@tokopedia.com",
                            fontSize = 16.sp, color = Color.Gray
                        )
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                // Text password & Text forgot password
                Row {
                    Text(
                        text = "KATA SANDI",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Lupa kata sandi?",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }
                // Password Input
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(
                            "Masukkan kata sandi",
                            fontSize = 16.sp, color = Color.Gray
                        )
                    },
                    visualTransformation = PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(24.dp))

                // Button Login
                Button(
                    onClick = { viewModel.doLogin(email, password) },
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp),
                    shape = MaterialTheme.shapes.medium
                ) {
                    if (loginState is LoginState.Loading) {
                        CircularProgressIndicator(
                            color = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    } else {
                        Text("Masuk", fontSize = 16.sp)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "ATAU MASUK DENGAN",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .align(Alignment.CenterHorizontally)
                )

                // Login with Google & Facebook
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { /* TODO: Login with Google */ },
                        colors = ButtonDefaults.buttonColors(Color.Gray.copy(alpha = 0.8f)),
                        modifier = Modifier
                            .weight(1f)
                            .height(44.dp),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Icon(Icons.Default.Email, contentDescription = "Google", tint = Color.Red)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Google", fontSize = 14.sp, color = Color.Black.copy(alpha = 0.8f))
                    }
                    Button(
                        onClick = { /* TODO: Login with Facebook */ },
                        colors = ButtonDefaults.buttonColors(Color.Gray.copy(alpha = 0.8f)),
                        modifier = Modifier
                            .weight(1f)
                            .height(44.dp),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Icon(
                            Icons.Default.ShoppingCart,
                            contentDescription = "Facebook",
                            tint = Color.Black
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Facebook", fontSize = 14.sp, color = Color.Black.copy(alpha = 0.8f))
                    }
                }
                // Register Text
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp)
                ) {
                    Text(
                        text = "Belum punya akun?",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Daftar sekarang",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        // State Login
        when (loginState) {
            is LoginState.Success -> Text(
                "Login Berhasil! Selamat datang",
                color = Color.Green,
                modifier = Modifier.padding(top = 16.dp)
            )

            is LoginState.Error -> Text(
                "Gagal: ${(loginState as LoginState.Error).message}",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 16.dp)
            )

            else -> {
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginScreenPrev() {
    Tokped_cloneTheme {
        LoginScreen()
    }
}