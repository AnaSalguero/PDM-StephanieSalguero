package com.pdm0126.labo06.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pdm0126.labo06.viewModel.MealViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MealScreen(viewModel: MealViewModel= viewModel()) {
    val meals by viewModel.meals.collectAsStateWithLifecycle()
    val isLoading  by viewModel.isLoading.collectAsStateWithLifecycle()

    LaunchedEffect(Unit){
        viewModel.loadMeals()
    }
    when {
        isLoading -> {
            CircularProgressIndicator()
        }
        else -> {
            LazyColumn(Modifier.fillMaxSize()){
                items(meals) { meal ->
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)) {

                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text=meal.mealName)
                            Text(text=meal.country)
                            Text(text=meal.category)
                        }
                    }
                }
            }
        }
    }
}