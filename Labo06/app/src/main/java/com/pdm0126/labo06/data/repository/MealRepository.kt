package com.pdm0126.labo06.data.repository

import com.pdm0126.labo06.data.model.Meal

interface MealRepository {
    suspend fun getMeals(): Result<List<Meal>>
}