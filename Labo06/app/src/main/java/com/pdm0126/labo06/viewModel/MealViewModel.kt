package com.pdm0126.labo06.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.labo06.data.model.Meal
import com.pdm0126.labo06.data.repository.MealRepository
import com.pdm0126.labo06.data.repository.MealRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MealViewModel(private val repository: MealRepository= MealRepositoryImpl()) : ViewModel() {
    private val _meals = MutableStateFlow<List<Meal>>(emptyList())
    val meals: StateFlow<List<Meal>> = _meals.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun loadMeals(){
        viewModelScope.launch {
            _isLoading.value=true
            repository.getMeals()
                .onSuccess { _meals.value = it }
                .onFailure {it.printStackTrace()}
            _isLoading.value=false
        }
    }

}