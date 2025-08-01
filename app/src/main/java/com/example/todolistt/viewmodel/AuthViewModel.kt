package com.example.todolistt.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var error by mutableStateOf<String?>(null)

    fun login(onSuccess: () -> Unit) {
        if (email == "user@example.com" && password == "password") {
            onSuccess()
            error = null
        } else {
            error = "Invalid email or password"
        }
    }

    fun signup(onSuccess: () -> Unit) {
        if (email.length > 4 && password.length > 4) {
            onSuccess()
            error = null
        } else {
            error = "Use longer email and password"
        }
    }
}
