package com.mobile.crud.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.State
import com.mobile.crud.domain.CRUDProject
import com.mobile.crud.repository.DataProvider
import com.mobile.crud.ui.CRUDListItem

@SuppressLint("NewApi")
@Composable
fun CRUDHomeScreen(cruds: State<List<CRUDProject>>, deleteById: (Int) -> Unit, navigateToUpdate: (Int) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = cruds.value,
            itemContent = {
                CRUDListItem(crud = it, deleteById, { navigateToUpdate(it.id) })
            })
    }
}