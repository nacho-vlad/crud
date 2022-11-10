package com.mobile.crud

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.mobile.crud.ui.CRUDViewModel
import com.mobile.crud.ui.theme.CRUDTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mobile.crud.ui.CRUDAddScreen
import com.mobile.crud.ui.CRUDHomeScreen
import com.mobile.crud.ui.CRUDUpdateScreen

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CRUDTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(viewModel: CRUDViewModel = viewModel()) {
    val navController = rememberNavController()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("add") },
                containerColor = Color.Magenta,
                contentColor = Color.White,
                ) {
                Icon(Icons.Filled.Add, "")
            }
        },
        content = {
            Navigation(navController, viewModel)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(navController: NavHostController, viewModel: CRUDViewModel) {
    NavHost(navController, startDestination = "home") {
        composable(route = "home") {
            CRUDHomeScreen(viewModel.crudList.collectAsState(initial = listOf()),
                viewModel::deleteById
            ) { id ->
                navController.navigate("update/$id")
            }
        }
        composable(route = "add") {
            CRUDAddScreen(viewModel::addProject, navController::popBackStack)
        }
        composable(route = "update/{crudId}") { backStackEntry ->
            CRUDUpdateScreen(
                Integer.parseInt(backStackEntry.arguments?.getString("crudId")!!),
                viewModel::getById,
                viewModel::updateProject,
                navController::popBackStack)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CRUDTheme {
        Greeting("Android")
    }
}