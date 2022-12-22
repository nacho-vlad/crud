package com.mobile.crud.repository

import androidx.room.Database
import com.mobile.crud.domain.CRUDProject
import com.mobile.crud.domain.CRUDProjectDao

@Database(entities = [CRUDProject::class], version=1)
abstract class AppDatabase {
    abstract fun crudDao(): CRUDProjectDao
}