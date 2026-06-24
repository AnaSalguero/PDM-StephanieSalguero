package com.pdm0126.labo06.data.api.Meals

import kotlinx.serialization.Serializable

@Serializable
data class GetMealsDto(
    val results: List<MealDto>
)
