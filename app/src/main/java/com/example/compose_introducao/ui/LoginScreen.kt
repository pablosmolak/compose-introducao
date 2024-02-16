package com.example.compose_introducao.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.jetbrains.annotations.Async


@Composable
fun LoginScreen(){
    var email by remember { mutableStateOf("")}
    var senha by remember { mutableStateOf("")}

    Surface (
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            AsyncImage(
                model = "https://minhabiblioteca.com.br/wp-content/uploads/2021/04/logo-IFRO.png",
                contentDescription = "logo do IFRO",
                modifier = Modifier
                    .padding(top = 160.dp, bottom = 100.dp)
                    .size(200.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                label = { Text(text = "Email")},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = senha,
                onValueChange = {senha = it},
                label = { Text(text = "Senha")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(top = 30.dp, bottom = 15.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    Color.Black
                )
            ){
                Text("Entrar")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}