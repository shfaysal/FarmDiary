package com.example.farmdiary.farmDiary.presentation.navigation

sealed class Screens (val route: String) {
    object ScreenLoginRoute : Screens(route = "Login")
    object ScreenSignUpRoute : Screens(route = "SignUp")
    object ScreenHomeRoute : Screens(route = "Home")
    object ScreenFarmCoRoute : Screens(route = "FarmCo")
    object ScreenCameraRoute : Screens(route = "Camera")
    object ScreenChatBotRoute : Screens(route = "ChatBot")
    object ScreenProfileRoute : Screens(route = "Profile")
    object ManageStoreRoute : Screens(route = "ManageStore")
    object AuthRoute : Screens(route = "Auth")
    object AppRoute : Screens(route = "App")
}