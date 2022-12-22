package com.mobile.crud.domain

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CRUDProjectDao {

    @Query("SELECT * FROM CRUDProject")
    fun getAll(): Flow<List<CRUDProject>>

    @Insert
    fun insert(vararg crud: CRUDProject)

    @Delete
    fun deleteProject(vararg crud: CRUDProject)
}