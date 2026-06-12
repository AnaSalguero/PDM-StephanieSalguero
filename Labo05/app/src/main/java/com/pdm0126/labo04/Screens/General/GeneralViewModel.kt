package com.pdm0126.labo04.Screens.General

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.labo04.Data.Database.InitDatabase
import kotlinx.coroutines.launch
import com.pdm0126.labo04.Data.Database.Entities.TaskEntity
import com.pdm0126.labo04.Data.Database.Entities.toEntity
import com.pdm0126.labo04.Data.Database.Entities.toModel
import com.pdm0126.labo04.Model.Task
import kotlinx.coroutines.flow.map

class GeneralViewModel: ViewModel() {

    private val dao = InitDatabase.database.TaskDao()

    val tasks = dao.getAlltasks().map { list ->
        list.map{ it.toModel()}
    }

    fun addTask(task: Task) {
        viewModelScope.launch{
            dao.insertTask(task.toEntity())
        }
    }
}