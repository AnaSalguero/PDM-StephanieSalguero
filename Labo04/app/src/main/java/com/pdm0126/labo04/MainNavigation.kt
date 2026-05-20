package com.pdm0126.labo04

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.labo04.Screens.General.General
import com.pdm0126.labo04.Screens.Menu.Menu

@Composable
fun App(){
    val backStack = rememberNavBackStack(Routes.Menu)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider{
            entry<Routes.Menu> {
                Menu(
                    navigateList = {backStack.add(Routes.List)}
                )
            }
            entry<Routes.List> {
                General()
            }
        })
}