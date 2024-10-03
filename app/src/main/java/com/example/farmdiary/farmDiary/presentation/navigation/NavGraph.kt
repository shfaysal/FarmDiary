package com.example.farmdiary.farmDiary.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController


@Composable
fun Nav(navController: NavController){
//    val navController = rememberNavController()

    NavHost(
        navController = navController as NavHostController,
        startDestination = Screens.AppRoute.route)
    {
        authGraph(navController)
        appGraph(navController)
    }
}