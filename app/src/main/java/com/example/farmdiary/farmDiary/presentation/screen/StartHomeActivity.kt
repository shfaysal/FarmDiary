package com.example.farmdiary.farmDiary.presentation.screen

import ChatbotUI
import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.farmdiary.TopBar
import com.example.farmdiary.farmDiary.presentation.navigation.Nav
import com.example.farmdiary.farmDiary.presentation.navigation.Screens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun StartApp(navController: NavController){

    Scaffold (
        bottomBar = {
            BottomBar(navController = navController)
        },
        topBar = {
            TopBar(navController = navController)
        },
        floatingActionButton = {
            FloatingButton()
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        NavHost(
            navController = navController as NavHostController,
            startDestination = Screens.ScreenHomeRoute.route
        ) {
            composable(route = Screens.ScreenHomeRoute.route) {
                Home(navController = navController)
            }

            composable(route = Screens.ScreenFarmCoRoute.route) {
                FarmCoScreen(navController = navController)
            }

            composable(route = Screens.ScreenCameraRoute.route) {
                // Define your camera screen here
            }

            composable(route = Screens.ScreenChatBotRoute.route) {
                ChatbotUI(navController = navController)
            }

            composable(route = Screens.ScreenProfileRoute.route) {
                UserProfileScreen(navController = navController)
            }
        }
    }
}
