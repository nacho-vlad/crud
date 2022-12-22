package com.mobile.crud.repository

import com.mobile.crud.domain.CRUDProject
import com.mobile.crud.domain.CRUDProjectData
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun addCRUD(crud: CRUDProjectData)
    fun deleteCRUD(crudId: Int)
    fun updateCRUD(oldId: Int, newCrud: CRUDProjectData)
    fun getCRUDList(): Flow<List<CRUDProject>>
    fun getById(crudId: Int): CRUDProject
}