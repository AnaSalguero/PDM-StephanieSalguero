package com.pdm0126.labo04

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey{
    @Serializable
    data object Menu: Routes()
    @Serializable
    data object List: Routes()
}