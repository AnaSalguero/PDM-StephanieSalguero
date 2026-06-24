package com.pdm0126.labo06.data.api.Meals

import com.pdm0126.labo06.data.model.Meal
import kotlinx.serialization.Serializable

@Serializable
data class MealDto(
    val idMEal:Int,
    val strMeal: String,
    val strCategory: String,
    val strCountry: String,
)

fun MealDto.toModel() : Meal {
    return Meal(
        id= idMEal,
        mealName = strMeal,
        category = strCategory,
        country = strCountry,
    )
}