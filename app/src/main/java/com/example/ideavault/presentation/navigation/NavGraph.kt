package com.example.ideavault.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ideavault.data.local.database.IdeaDatabase
import com.example.ideavault.data.repository.IdeaRepositoryImpl
import com.example.ideavault.presentation.dashboard.DashboardScreen
import com.example.ideavault.presentation.dashboard.DashboardViewModel
import com.example.ideavault.presentation.dashboard.DashboardViewModelFactory

@Composable
fun NavGraph(database: IdeaDatabase) {
    val navController = rememberNavController()
    val repository = IdeaRepositoryImpl(database.ideaDao())
    val dashboardViewModel = viewModel<DashboardViewModel>(factory = DashboardViewModelFactory(repository))

    NavHost(navController = navController, startDestination = "dashboard") {

        composable("dashboard") {
            DashboardScreen(
                viewModel = dashboardViewModel,
                onIdeaClick = { ideaId -> navController.navigate("detail/$ideaId") }
            )
        }

        composable("detail/{ideaId}") {
            // 2주차에 구현
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            }
        }
    }
}
