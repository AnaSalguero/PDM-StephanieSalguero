package com.pdm0126.labo3

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.labo3.Pantalla.ListaNombres
import com.pdm0126.labo3.Pantalla.ListaSensores
import com.pdm0126.labo3.Routes
import com.pdm0126.labo3.Pantalla.Menu

@Composable
fun App(modifier: Modifier){
    val backStack = rememberNavBackStack(Routes.Menu)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Menu> {
                Menu(
                    navNombres = {
                        backStack.add(Routes.Nombres)
                    },
                    navSensor = {
                        backStack.add(Routes.Sensores)
                    }
                )
            }
            entry<Routes.Nombres> {
                ListaNombres(
                    navigateBack = {backStack.removeLastOrNull()}
                )
            }
            entry<Routes.Sensores> {
                ListaSensores(
                    navigateBack = {backStack.removeLastOrNull()}
                )
            }
        }
    )
}