package com.mobile.crud.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobile.crud.domain.CRUDProject

@Composable
fun CRUDListItem(crud: CRUDProject, deleteById: (Int) -> Unit, navigateToUpdate: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable(
                onClick = navigateToUpdate
            ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 2.dp,
            hoveredElevation = 4.dp
        ),
        shape = RoundedCornerShape(corner = CornerSize(size = 16.dp)),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = crud.title, style = typography.headlineMedium)
                crud.course?.let { Text(text = it, style = typography.bodyLarge) }
            }
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically),
                horizontalAlignment = Alignment.End
            ) {
                IconButton(
                    onClick = { deleteById(crud.id) },
                    modifier = Modifier.size(30.dp, 30.dp),
                    content = {
                        Icon(Icons.Filled.Delete, "", modifier = Modifier.size(30.dp, 30.dp))
                    })
            }
        }
    }
}