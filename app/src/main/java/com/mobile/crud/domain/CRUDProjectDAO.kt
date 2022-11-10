package com.mobile.crud.domain

import java.time.LocalDate

data class CRUDProjectDAO(
    val title: String,
    val description: String?,
    val course: String?,
    val date: LocalDate?,
    val hours: Int
)