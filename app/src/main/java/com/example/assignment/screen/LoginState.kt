package com.example.assignment.screen

// Store Login details for user
data class LoginState(
    val email: String = "", // storing user's email (read-only)
    val password: String = "", // storing user's password (read-only)
    val isLoading: Boolean = false, // storing status whether the function is loading (read-only)
    val errorMessage: String ?= null // storing error message
)
