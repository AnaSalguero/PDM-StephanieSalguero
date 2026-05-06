package com.pdm0126.labo3.Pantalla

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Menu(navNombres: () -> Unit, navSensor:()->Unit){
    Column(modifier=Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Box(){
            Text("Menu")
        }
        Button(onClick = {navNombres()}){
            Text("Visualizar Lista")
        }
        Button(onClick = {navSensor()}){
            Text("Visualizar Sensores")
        }
    }
}
