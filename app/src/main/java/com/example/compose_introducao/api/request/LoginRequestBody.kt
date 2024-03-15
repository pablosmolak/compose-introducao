package com.example.compose_introducao.api.request

data class LoginRequestBody (
    var email: String = "",
    var senha: String = ""
)