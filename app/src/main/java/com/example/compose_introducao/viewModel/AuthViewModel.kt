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
    val loading = mutableStateOf(false)
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

        if(senha == "1" && user == "1"){
            loading.value = true
            viewModelScope.launch {
                delay(1000)
                appDataStore.putBollean(AppDataStoreKeys.AUTENTICADO, true).apply {
                    onSuccess()
                }
            }
        }else{
            onError("Usuário ou senha incorretos!")
        }

    }

    fun logout(
        onSuccess: () -> Unit
    ){
        loading.value = true
        viewModelScope.launch {
            delay(500)
            appDataStore.putBollean(AppDataStoreKeys.AUTENTICADO, false).apply {
                onSuccess()
            }
        }
    }
}