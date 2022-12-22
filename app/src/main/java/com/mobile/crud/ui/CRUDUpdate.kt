package com.mobile.crud.ui

import android.app.DatePickerDialog
import android.os.Build
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.mobile.crud.domain.CRUDProject
import com.mobile.crud.domain.CRUDProjectData
import java.time.LocalDate
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CRUDUpdateScreen(crudId: Int, getById: (Int) -> CRUDProject, updateProject: (Int, CRUDProjectData) -> Unit, navigateBack: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 2.dp,
            hoveredElevation = 4.dp
        ),
        shape = RoundedCornerShape(corner = CornerSize(size = 16.dp)),
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .fillMaxWidth()
        ) {
            Text("Update CRUD project", style = MaterialTheme.typography.headlineMedium)

            val oldProject = getById(crudId)

            var projectName by remember { mutableStateOf(TextFieldValue(oldProject.title)) }

            TextField(
                value = projectName,
                onValueChange = { newText ->
                    projectName = newText
                },
                label = { Text("Name") }
            )

            var courseName by remember { mutableStateOf(TextFieldValue(oldProject.course!!)) }

            TextField(
                value = courseName,
                onValueChange = { newText ->
                    courseName = newText
                },
                label = { Text("Course") }
            )

            var description by remember { mutableStateOf(TextFieldValue(oldProject.description!!)) }

            TextField(
                value = description,
                onValueChange = { newText ->
                    description = newText
                },
                label = { Text("Description") }
            )


            // Fetching the Local Context
            val mContext = LocalContext.current

            // Initializing a Calendar
            val mCalendar = Calendar.getInstance()

            mCalendar.time = Date()

            // Declaring a string value to
            // store date in string format
            var mDate by remember { mutableStateOf(oldProject.date!!) }

            // Declaring DatePickerDialog and setting
            // initial values as current values (present year, month and day)
            val mDatePickerDialog = DatePickerDialog(
                mContext,
                { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                    mDate = LocalDate.of(mYear, mMonth, mDayOfMonth)
                }, mDate.year, mDate.month.value, mDate.dayOfMonth
            )

            TextField(
                modifier = Modifier.clickable {
                    mDatePickerDialog.show()
                },
                value = mDate.toString(),
                onValueChange = { },
                label = { Text("Date Finished") },
                readOnly = true,
                enabled = false,
                colors = TextFieldDefaults.textFieldColors(
                    disabledTextColor = Color.LightGray,
                    disabledLabelColor =  Color.LightGray,
                    disabledIndicatorColor = Color.LightGray
                )
            )

            var hours by remember { mutableStateOf(oldProject.hours) }
            TextField(
                value = hours.toString(),
                onValueChange = { value ->
                    hours = if (value.isEmpty()) {
                        0
                    } else {
                        Integer.parseInt(value.filter { it.isDigit() })
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("Hours spent") }
            )

            Button(
                onClick = {
                    updateProject(crudId,
                        CRUDProjectData(
                        title = projectName.text,
                        description = description.text,
                        course = courseName.text,
                        date = mDate,
                        hours = hours))
                    navigateBack()
                }
            ) {
                Text("Update", color = Color.White)
            }

        }

    }
}