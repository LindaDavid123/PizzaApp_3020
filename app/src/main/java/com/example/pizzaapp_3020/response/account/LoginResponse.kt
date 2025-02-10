package com.example.pizzaapp_3020.response.account

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val `data`: Data
)
