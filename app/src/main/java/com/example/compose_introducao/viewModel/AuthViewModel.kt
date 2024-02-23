package com.example.compose_introducao.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import coil.compose.AsyncImagePainter

class AuthViewModel: ViewModel() {

    val autenticado = mutableStateOf(false)

    fun login (
        user: String,
        senha: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ){

        if(user == "smolak"  && senha == "1234"){
            onSuccess()
        }else{
            onError("Usuário ou senha Inválida")
        }

    }
}