package com.demo.example.model

data class RegisterRequest(
        val email: String,
        val password: String
)
data class RegisterResult(
        val id: Int,
        val token: String
)
