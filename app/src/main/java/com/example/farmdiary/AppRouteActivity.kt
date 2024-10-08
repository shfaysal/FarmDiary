package com.example.farmdiary

import ChatbotUI
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.farmdiary.farmDiary.presentation.navigation.Screens
import com.example.farmdiary.farmDiary.presentation.screen.BottomBar
import com.example.farmdiary.farmDiary.presentation.screen.FarmCoScreen
import com.example.farmdiary.farmDiary.presentation.screen.FloatingButton
import com.example.farmdiary.farmDiary.presentation.screen.Home
import com.example.farmdiary.farmDiary.presentation.screen.UserProfileScreen
import com.example.farmdiary.ui.theme.FarmDiaryTheme

class AppRouteActivity() : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Log.d("ROUTE", "App Route")
            FarmDiaryTheme {
                val navController = rememberNavController()
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
                        navController = navController,
                        startDestination = Screens.ScreenHomeRoute.route) {

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
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    FarmDiaryTheme {
        Greeting2("Android")
    }
}