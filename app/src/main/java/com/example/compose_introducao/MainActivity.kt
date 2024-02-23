package com.example.compose_introducao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose_introducao.ui.InicioScreen
import com.example.compose_introducao.ui.LoginScreen
import com.example.compose_introducao.ui.theme.ComposeintroducaoTheme
import com.example.composeintroduoaula.ui.MinhaContaScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeintroducaoTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "inicio"
                ) {
                    composable("login"){
                        LoginScreen(navController)
                    }

                    composable("inicio"){
                        InicioScreen(navController)
                    }

                    composable("minha-conta"){
                        MinhaContaScreen(navController)
                    }
                }

            }
        }
    }
}