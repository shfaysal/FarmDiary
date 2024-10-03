package com.example.farmdiary.farmDiary.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.farmdiary.farmDiary.presentation.screen.LoginRegisterScreen

//import com.example.farmdiary.farmDiary.presentation.screen.LogInScreen
//import com.example.farmdiary.farmDiary.presentation.screen.SignUp

fun NavGraphBuilder.authGraph(navController: NavController){

    navigation(
        startDestination = Screens.ScreenLoginRoute.route,
        route = Screens.AuthRoute.route
    ){
        composable(route = Screens.ScreenLoginRoute.route){
            LoginRegisterScreen(navController = navController)
        }
//
//        composable(route = Screens.ScreenSignUpRoute.route){
//            SignUp(navController = navController)
//        }
    }
}