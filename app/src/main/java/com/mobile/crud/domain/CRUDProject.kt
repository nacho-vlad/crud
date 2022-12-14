package com.mobile.crud.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class CRUDProject(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String?,
    var course: String?,
    val date: LocalDate?,
    val hours: Int
)
