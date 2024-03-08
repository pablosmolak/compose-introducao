package com.example.composeintroduoaula.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.compose_introducao.R
import com.example.compose_introducao.ui.LoadingScreen
import com.example.compose_introducao.viewModel.AuthViewModel

@Composable
fun MinhaContaScreen(
    navController: NavController
) {
    val authViewModel = hiltViewModel<AuthViewModel>()
    val showAlert = remember { mutableStateOf(false)  }

    Surface (
        color = Color.LightGray,
        modifier = Modifier.fillMaxSize()
    ) {


        Column(
            modifier = Modifier
                .padding(24.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Minha conta",
                style = MaterialTheme.typography.headlineMedium
            )

            Box(
                modifier = Modifier.padding(16.dp)
            ) {
                AsyncImage(
                    model = "https://lh3.googleusercontent.com/a/ACg8ocJPRoERYDoH5WkGDsN8DJKVHLj6iOQ7K5qCUBTFbE8z3WY=s288-c-no",
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(140.dp)
                        .clip(CircleShape)
                )

                Button(
                    onClick = {

                    },
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.BottomEnd)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_edit),
                        contentDescription = null,
                        tint = Color.LightGray
                    )
                }
            }

            Text(
                "Pablo Smolak",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                "pablosmolak@gmail.com",
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    color = Color.Gray
                )
            )

            Button(
                onClick = {
                    showAlert.value = true
                },
                modifier = Modifier.padding(top = 24.dp)
            ) {
                Text("Sair")
            }
        }

        if (authViewModel.loading.value) {
            LoadingScreen()
        }

        if (showAlert.value) {
            AlertDialog(
                onDismissRequest = {
                    showAlert.value = false
                },
                title = {
                    Text(text = "Deseja realmente sair?")
                },
                text = {
                    Text("Não será possível acessar informações e receber notificações pessoais.")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showAlert.value = false
                            authViewModel.logout(
                                onSuccess = {
                                    navController.navigate("inicio")
                                }
                            )


                        }
                    ) {
                        Text("Sair")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            showAlert.value = false
                        }
                    ) {
                        Text("Cancelar")
                    }
                }
            )
        }
    }
}
