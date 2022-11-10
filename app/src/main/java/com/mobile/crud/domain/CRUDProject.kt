package com.mobile.crud.domain

import java.time.LocalDate

data class CRUDProject(
    val id: Int,
    val title: String,
    val description: String?,
    var course: String?,
    val date: LocalDate?,
    val hours: Int
)
