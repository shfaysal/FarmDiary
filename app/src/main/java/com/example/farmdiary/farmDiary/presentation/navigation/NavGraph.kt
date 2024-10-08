package com.example.farmdiary.farmDiary.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.farmdiary.AppRouteActivity
import com.example.farmdiary.farmDiary.presentation.screen.StartApp


@Composable
fun Nav(navController: NavController){
//    val navController = rememberNavController()

    NavHost(
        navController = navController as NavHostController,
        startDestination = Screens.AuthRoute.route
    )
    {
        authGraph(navController)
//        appAndAuthLink(navController)
        composable(
            route = Screens.StartApp.route
        ){
            StartApp(navController = navController)
        }
//        appGraph(navController)
    }
}