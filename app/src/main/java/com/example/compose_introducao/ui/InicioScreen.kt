package com.example.compose_introducao.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InicioScreen(){
    Surface (
        color = Color.LightGray,
        modifier = Modifier.fillMaxSize(),
    ){
       Column(
           verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
           horizontalAlignment = Alignment.CenterHorizontally
       ){
           Text("Não Autenticado")
           OutlinedButton(onClick = {}){
               Text("Minha Conta")
           }
       }
    }
}

@Preview(showSystemUi = true)
@Composable
fun InicioScreenPreview() {
   InicioScreen()
}