package com.mobile.crud.ui

import android.app.DatePickerDialog
import android.os.Build
import androidx.compose.ui.graphics.Color
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import com.mobile.crud.domain.CRUDProjectData
import java.time.LocalDate
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalMaterial3Api
@Composable
fun CRUDAddScreen(addProject: (CRUDProjectData) -> Unit, navigateBack: () -> Unit) {
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
            Text("Add new CRUD project", style = typography.headlineMedium)

            var projectName by remember { mutableStateOf(TextFieldValue("")) }

            TextField(
                value = projectName,
                onValueChange = { newText ->
                    projectName = newText
                },
                label = { Text("Name") }
            )

            var courseName by remember { mutableStateOf(TextFieldValue("")) }

            TextField(
                value = courseName,
                onValueChange = { newText ->
                    courseName = newText
                },
                label = { Text("Course") }
            )

            var description by remember { mutableStateOf(TextFieldValue(""))}

            TextField(
                value = description,
                onValueChange = { newText ->
                    description = newText
                },
                label = { Text("Description") }
            )


            // Fetching the Local Context
            val mContext = LocalContext.current

            // Declaring integer values
            // for year, month and day
            val mYear: Int
            val mMonth: Int
            val mDay: Int

            // Initializing a Calendar
            val mCalendar = Calendar.getInstance()

            // Fetching current year, month and day
            mYear = mCalendar.get(Calendar.YEAR)
            mMonth = mCalendar.get(Calendar.MONTH)
            mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

            mCalendar.time = Date()

            // Declaring a string value to
            // store date in string format
            var mDate by remember { mutableStateOf(LocalDate.of(mYear, mMonth, mDay)) }

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

            var hours by remember {mutableStateOf(0)}
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
                    addProject(CRUDProjectData(
                        title = projectName.text,
                        description = description.text,
                        course = courseName.text,
                        date = mDate,
                        hours = hours))
                    navigateBack()
                }
            ) {
                Text("Add", color = Color.White)
            }

        }

    }
}
