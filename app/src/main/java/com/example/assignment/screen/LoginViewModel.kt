package com.example.assignment.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment.AppModule
import kotlinx.coroutines.launch
import com.example.assignment.data.repository.UserRepository

class LoginViewModel(
    private val userRepository: UserRepository = UserRepository(supabase = AppModule.supabase)
) : ViewModel() {

    var state by mutableStateOf(LoginState())
    private set

    fun onEmailChange(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordChange(password: String) {
        state = state.copy(password = password)
    }

    fun saveUser(onSuccess: () -> Unit) {
        if(state.email.isBlank() || state.password.isBlank()) {
            state = state.copy(errorMessage = "You must enter your email and password!")
            return
        }

        state = state.copy(isLoading = true, errorMessage = null)

        viewModelScope.launch {
            val result = userRepository.storeProfile(
                currentEmail = state.email,
                currentPassword = state.password
            )

            result.fold(
                onSuccess = {
                    state = state.copy(
                        isLoading = false
                    )
                    onSuccess()
                },
                onFailure = { error ->
                    state = state.copy(
                        isLoading = false,
                        errorMessage = error.localizedMessage ?: "Invalid Login!"
                    )
                }
            )
        }
    }
}