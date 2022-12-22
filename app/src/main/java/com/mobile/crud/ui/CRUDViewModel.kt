package com.mobile.crud.ui

import androidx.lifecycle.ViewModel
import com.mobile.crud.domain.CRUDProject
import com.mobile.crud.domain.CRUDProjectData
import com.mobile.crud.repository.MemoryRepository
import com.mobile.crud.repository.Repository

class CRUDViewModel(
) : ViewModel() {
    private var repository: Repository = MemoryRepository()
    val crudList = repository.getCRUDList()

    fun deleteById(crudId: Int) {
        repository.deleteCRUD(crudId)
    }

    fun addProject(crud: CRUDProjectData) {
        repository.addCRUD(crud)
    }

    fun updateProject(crudId: Int, crud: CRUDProjectData) {
        repository.updateCRUD(crudId, crud)
    }

    fun getById(crudId: Int): CRUDProject {
        return repository.getById(crudId)
    }
}