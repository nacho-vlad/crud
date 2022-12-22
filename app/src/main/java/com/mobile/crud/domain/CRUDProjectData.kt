package com.mobile.crud.domain

import java.time.LocalDate

data class CRUDProjectData(
    val title: String,
    val description: String?,
    val course: String?,
    val date: LocalDate?,
    val hours: Int
)