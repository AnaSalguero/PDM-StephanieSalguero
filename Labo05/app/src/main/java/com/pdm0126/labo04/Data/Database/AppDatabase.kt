package com.pdm0126.labo04.Data.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pdm0126.labo04.Data.Database.Dao.TaskDao
import com.pdm0126.labo04.Data.Database.Entities.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun TaskDao(): TaskDao
}