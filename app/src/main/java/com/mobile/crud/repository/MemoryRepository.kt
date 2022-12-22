package com.mobile.crud.repository

import com.mobile.crud.domain.CRUDProject
import com.mobile.crud.domain.CRUDProjectData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MemoryRepository: Repository {
    private val list = MutableStateFlow(DataProvider.crudList);
    var id = 100;
    override fun addCRUD(crud: CRUDProjectData) {
        id += 1
        list.update { old -> old + CRUDProject(
            id = id,
            title = crud.title,
            description = crud.description,
            course = crud.course,
            date = crud.date,
            hours = crud.hours
        ) }
    }

    override fun deleteCRUD(crudId: Int) {
        list.update {old -> old.filter {crud -> crud.id != crudId}}
    }

    override fun getCRUDList(): Flow<List<CRUDProject>> {
        return list.asStateFlow();
    }

    override fun updateCRUD(crudId: Int, newCrud: CRUDProjectData) {
        list.update { old ->
            old.map { crud ->
                if (crud.id != crudId) {
                    crud
                } else {
                    CRUDProject(
                        id = crudId,
                        title = newCrud.title,
                        description = newCrud.description,
                        course = newCrud.course,
                        date = newCrud.date,
                        hours = newCrud.hours
                    )
                }
            }
        }
    }

    override fun getById(crudId: Int): CRUDProject {
        return list.value.filter { it.id == crudId }[0]
    }

}