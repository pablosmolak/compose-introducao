package com.example.compose_introducao.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.compose.AsyncImagePainter
import com.example.compose_introducao.datastore.AppDataStore
import com.example.compose_introducao.datastore.AppDataStoreKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val appDataStore: AppDataStore
): ViewModel() {

    fun login (
        user: String,
        senha: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ){
        if(user.isEmpty()){
            onError("Informe o usuário!")
            return
        }

        if(senha.isEmpty()){
            onError("Informe a senha!")
            return
        }

        viewModelScope.launch {
            delay(2000)
            appDataStore.putBollean(AppDataStoreKeys.AUTENTICADO, true).apply {
                onSuccess()
            }
        }

    }

    fun Logout(
        onSuccess: () -> Unit
    ){

        viewModelScope.launch {
            appDataStore.putBollean(AppDataStoreKeys.AUTENTICADO, false).apply {
                onSuccess()
            }
        }
    }
}