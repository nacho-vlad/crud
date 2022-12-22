package com.mobile.crud.repository

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.mobile.crud.domain.CRUDProject
import java.time.LocalDate

object DataProvider {
    @SuppressLint("NewApi")
    val crudList = listOf(
        CRUDProject(
            id = 1,
            title = "Trench Coat",
            description = "",
            course = "OOP",
            date = LocalDate.of(2020, 11, 25),
            hours = 4,
        ),
        CRUDProject(
            id = 2,
            title = "Students",
            description = "",
            course = "FP",
            date = LocalDate.of(2020, 11, 25),
            hours = 2,
        ),
        CRUDProject(
            id = 3,
            title = "CRUD Projects",
            description = "",
            course = "Mobile",
            date = LocalDate.of(2020, 11, 25),
            hours = 10,
        ),
        CRUDProject(
            id = 4,
            title = "Movies",
            description = "",
            course = "Web",
            date = LocalDate.of(2020, 11, 25),
            hours = 2,
        ),
    );
}