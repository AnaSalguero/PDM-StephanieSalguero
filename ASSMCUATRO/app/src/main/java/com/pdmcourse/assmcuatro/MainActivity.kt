package com.pdmcourse.assmcuatro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pdmcourse.assmcuatro.ui.theme.ASSMCUATROTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ASSMCUATROTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val nombre: MutableState<String> = remember{ mutableStateOf("") }
    val lista = remember{mutableStateListOf("")}
    Column(modifier=Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        TextField(value = nombre.value,
            onValueChange = {nombre.value = it},
            label = {Text("Nombre")}
        )
        Button(onClick = {
            lista.add(nombre.value)
        }){
            Text(text = "Guardar")
        }
        Row(modifier=Modifier.padding(start = 10.dp, end = 10.dp)){
            Box(modifier = Modifier.weight(1f)){
                Text(text = "Lista de nombres y posicion en la lista")
            }
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterEnd){
                Button(onClick = { lista.clear() }) {
                    Text(text = "Limpiar")
                }
            }
        }
        LazyColumn {
            itemsIndexed(lista.toList()) { index, item ->
                Row(
                        modifier = Modifier
                            .padding(25.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                            text = item
                    )
                    Text(
                            text = (index + 1).toString()
                    )
                }
            }
        }


    }



}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    ASSMCUATROTheme {
        App()
    }
}