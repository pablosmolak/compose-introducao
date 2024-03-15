package com.example.compose_introducao.api.response

import com.example.compose_introducao.api.model.Usuario

data class UsuarioResponseBody (
    var docs: List<Usuario>
)