package com.example.farmdiary.farmDiary.presentation.navigation

import ChatbotUI
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.farmdiary.farmDiary.presentation.screen.FarmCoScreen
import com.example.farmdiary.farmDiary.presentation.screen.Home
import com.example.farmdiary.farmDiary.presentation.screen.UserProfileScreen

fun NavGraphBuilder.appGraph(navController: NavController){
    navigation(startDestination = Screens.ScreenHomeRoute.route, route = Screens.AppRoute.route){
        composable(route = Screens.ScreenHomeRoute.route) {
            Home(navController = navController)
        }
        composable(route = Screens.ScreenFarmCoRoute.route) {
            FarmCoScreen(navController = navController)
        }
        composable(route = Screens.ScreenCameraRoute.route) {
//            ScreenB(navController = navController)
        }
        composable(route = Screens.ScreenChatBotRoute.route) {
            ChatbotUI(navController = navController)
        }
        composable(route = Screens.ScreenProfileRoute.route) {
            UserProfileScreen(navController = navController)
        }
    }
}