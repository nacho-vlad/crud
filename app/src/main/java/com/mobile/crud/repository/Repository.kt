package com.mobile.crud.repository

import com.mobile.crud.domain.CRUDProject
import com.mobile.crud.domain.CRUDProjectDAO
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun addCRUD(crud: CRUDProjectDAO)
    fun deleteCRUD(crudId: Int)
    fun updateCRUD(oldId: Int, newCrud: CRUDProjectDAO)
    fun getCRUDList(): Flow<List<CRUDProject>>
    fun getById(crudId: Int): CRUDProject
}