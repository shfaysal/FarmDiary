package com.example.farmdiary

import android.os.Bundle
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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.farmdiary.farmDiary.presentation.navigation.Nav
import com.example.farmdiary.farmDiary.presentation.navigation.Screens
import com.example.farmdiary.farmDiary.presentation.screen.BottomBar
import com.example.farmdiary.farmDiary.presentation.screen.FloatingButton
import com.example.farmdiary.farmDiary.presentation.screen.Home
import com.example.farmdiary.farmDiary.presentation.screen.TopAppBarWithBackButton
import com.example.farmdiary.ui.theme.FarmDiaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            FarmDiaryTheme {
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
                ) { innerPadding ->
                    Nav(navController)

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FarmDiaryTheme {
        Greeting("Android")
    }
}

@Composable
fun TopBar(navController: NavController) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry.value?.destination?.route

    // Configure TopAppBar based on the current route
    when (currentDestination) {
        Screens.ScreenHomeRoute.route -> TopAppBarWithBackButton(title = "Farmer Diary", isHome = true) { /* No back button on Home */ }
        Screens.ScreenFarmCoRoute.route -> TopAppBarWithBackButton(title = "FarmCo", isHome = false) { navController.navigateUp() }
        Screens.ScreenChatBotRoute.route -> TopAppBarWithBackButton(title = "Chat Bot", isHome = false) { navController.navigateUp() }
        Screens.ScreenProfileRoute.route -> TopAppBarWithBackButton(title = "Profile", isHome = false) { navController.navigateUp() }
        Screens.ScreenCameraRoute.route -> TopAppBarWithBackButton(title = "Camera", isHome = false) { navController.navigateUp() }
        else -> TopAppBarWithBackButton(title = "Farmer Diary", isHome = true) { /* Default fallback */ }
    }
}