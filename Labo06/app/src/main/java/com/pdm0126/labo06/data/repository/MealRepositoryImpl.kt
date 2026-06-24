package com.pdm0126.labo06.data.repository

import com.pdm0126.labo06.data.api.Meals.MealDto
import com.pdm0126.labo06.data.api.ktorClient
import com.pdm0126.labo06.data.model.Meal
import io.ktor.client.request.get
import io.ktor.client.call.body
import com.pdm0126.labo06.data.api.Meals.toModel

class MealRepositoryImpl: MealRepository {
    override suspend fun getMeals(): Result<List<Meal>> {
        return try {
            val meals = ktorClient.client.get("https://www.themealdb.com/api/json/v1/1/search.php?s=")
                .body<List<MealDto>>().map{it.toModel()}
            Result.success(meals)
        }catch (e: Exception){
            Result.failure(e)
        }
    }
}