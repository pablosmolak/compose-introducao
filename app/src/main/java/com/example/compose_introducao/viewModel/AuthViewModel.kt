package com.example.compose_introducao.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.compose.AsyncImagePainter
import com.example.compose_introducao.api.AuthEndPoint
import com.example.compose_introducao.api.request.LoginRequestBody
import com.example.compose_introducao.api.response.LoginResponseBody
import com.example.compose_introducao.datastore.AppDataStore
import com.example.compose_introducao.datastore.AppDataStoreKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val appDataStore: AppDataStore
) : ViewModel() {
    val loading = mutableStateOf(false)
    fun login(
        user: String,
        senha: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        if (user.isEmpty()) {
            onError("Informe o usuário!")
            return
        }

        if (senha.isEmpty()) {
            onError("Informe a senha!")
            return
        }

        loading.value = true

        val requestBody = LoginRequestBody()
        requestBody.email = user
        requestBody.senha = senha

        val retrofit = Retrofit.Builder()
            .client(OkHttpClient.Builder().build())
            .baseUrl("https://api-estudos.vercel.app")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val endpoint = retrofit.create(AuthEndPoint::class.java)


        viewModelScope.launch {
            val callback = endpoint.login(requestBody)

            callback.enqueue(object : Callback<LoginResponseBody> {
                override fun onFailure(call: Call<LoginResponseBody>, t: Throwable) {
                    if (t.message.isNullOrBlank()) {
                        onError("No fail message avaliable")
                    } else {
                        onError(t.message!!)
                    }
                }

                override fun onResponse(
                    call: Call<LoginResponseBody>,
                    response: Response<LoginResponseBody>
                ) {
                    onSuccess()
                    println(response.code())

                    if(response.isSuccessful) {
                        println(response.body()!!.token)
                    }
                }
            })

            appDataStore.putBollean(AppDataStoreKeys.AUTENTICADO, true).apply {
                onSuccess()
            }
        }


    }
    fun logout(
        onSuccess: () -> Unit
    ) {
        loading.value = true
        viewModelScope.launch {
            delay(500)
            appDataStore.putBollean(AppDataStoreKeys.AUTENTICADO, false).apply {
                onSuccess()
            }
        }
    }
}