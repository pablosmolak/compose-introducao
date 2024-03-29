package com.example.compose_introducao.api.response

import com.example.compose_introducao.api.model.Usuario

data class LoginResponseBody (
    var token: String = "",
    var usuario: Usuario
)