package com.example.compose_introducao.api.model

data class Usuario (
    var _id: String = "",
    var nome: String = "",
    var email: String = "",
    var foto : String? = null
)