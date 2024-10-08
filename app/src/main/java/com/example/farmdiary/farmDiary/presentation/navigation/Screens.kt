package com.example.farmdiary.farmDiary.presentation.navigation

sealed class Screens (val route: String) {
    data object ScreenLoginRoute : Screens(route = "Login")
    data object ScreenSignUpRoute : Screens(route = "SignUp")
    data object ScreenHomeRoute : Screens(route = "Home")
    data object ScreenFarmCoRoute : Screens(route = "FarmCo")
    data object ScreenCameraRoute : Screens(route = "Camera")
    data object ScreenChatBotRoute : Screens(route = "ChatBot")
    data object ScreenProfileRoute : Screens(route = "Profile")
    data object ManageStoreRoute : Screens(route = "ManageStore")
    data object AuthRoute : Screens(route = "Auth")
    data object AppRoute : Screens(route = "App")
    data object StartApp : Screens(route = "StartApp")
    data object AuthAndAppLink : Screens(route = "AuthAndAppLink")
}