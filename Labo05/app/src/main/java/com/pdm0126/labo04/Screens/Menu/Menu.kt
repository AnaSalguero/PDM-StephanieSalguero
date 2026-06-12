package com.pdm0126.labo04.Screens.Menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Menu(navigateList: () ->Unit){
    Column(modifier = Modifier.fillMaxSize()){
        Button(onClick = {navigateList()}){
            Text("Entrar a lista")
        }
    }
}