package com.example.farmdiary.farmDiary.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.HeartBroken
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.farmdiary.R


@Composable
fun ProfileScreen(navController: NavController) {

    val scroll = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .clip(RoundedCornerShape(10.dp))
            .verticalScroll(scroll)
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
        ){
            // Close Button (Top Right)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(Color(0xFFD9D9D9)),
                contentAlignment = Alignment.TopEnd,

                ) {

                Box(modifier = Modifier.padding(20.dp)){
                    IconButton(onClick = { /* Handle close */ }) {
                        Icon(
                            modifier = Modifier.size(50.dp),
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = Color.Black
                        )
                    }
                }
            }

            // Profile Picture
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 130.dp, end = 20.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                CircleAvatar()
            }

        }


        Spacer(modifier = Modifier.height(8.dp))

        // User Info
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Lorem Ipsum",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed diam aliquip ex ea commodo consequat.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Review Section
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Rating Stars
                repeat(5) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star",
                        tint = Color(0xFF4CAF50),
                        modifier = Modifier.size(18.dp)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                // Number of Reviews
                Text(
                    text = "6 Review",
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Stats (Sells, Talk Time, Sessions)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            StatItem("527", "Sells", Icons.Outlined.ShoppingCart)
            VerticalDivider(modifier = Modifier.height(45.dp))
            StatItem("5 mins", "min talk time", Icons.Default.AccessTime)
            VerticalDivider(modifier = Modifier.height(45.dp))
            StatItem("36", "sessions", Icons.Outlined.Call)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Image Grid
        GridOfImages()

        Spacer(modifier = Modifier.height(16.dp))

        // Chat and Call Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ButtonChatAndCall(
                Color(0xFFE0EAFD),
                "Chat",
                Color(0xFF3F7DFF),
                Icons.Outlined.Chat,
                Color.White
            )
            Spacer(modifier = Modifier.width(5.dp))
            ButtonChatAndCall(
                Color(0xFF02AF37),
                "Start Call",
                Color.White,
                Icons.Outlined.Call,
                Color.Black
            )

//            Button(
//                onClick = { /* Handle Call */ },
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = Color(0xFF4CAF50)
//                ),
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(start = 8.dp),
//                shape = RoundedCornerShape(30.dp)
//            ) {
//                Row(
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.img), // Assuming call icon is in your resources
//                        contentDescription = "Call",
//                        tint = Color.White
//                    )
//                    Spacer(modifier = Modifier.width(8.dp))
//                    Text(text = "Start Call", color = Color.White)
//                }
//            }
        }
    }
}


@Composable
fun ButtonChatAndCall(
    buttonBackGround: Color,
    text: String,
    circleColor: Color,
    icon: ImageVector,
    tint: Color
){

    Box(
        modifier = Modifier
            .size(155.dp, 56.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(buttonBackGround)
            .padding(start = 15.dp),
    ){
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box (
                modifier = Modifier
                    .size(40.dp)
                    .clip(shape = CircleShape)
                    .background(circleColor),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon, // Assuming chat icon is in your resources
                    contentDescription = "Chat",
                    tint = tint
                )
            }

            Spacer(modifier = Modifier.width(8.dp))
            Text(
                modifier = Modifier.weight(10f),
                text = text,
                color = Color(0xFF1F57B9),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun CircleAvatar() {

    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {

        }

        Column (
            modifier = Modifier.padding(top = 15.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Box (
                modifier = Modifier
                    .size(100.dp, 35.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .shadow(elevation = 5.dp)
                    .background(Color(0xFFF6F8FA)),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.HeartBroken,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(5.dp))
                    Box (
                        modifier = Modifier.fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Like",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "404 Posts 1.6k likes")


        }

    }

}

@Composable
fun StatItem(value: String, label: String, icon: ImageVector) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}

@Composable
fun GridOfImages() {
    val images = List(6) { "" } // Placeholder images

    Column (
        Modifier.background(Color.White)
    ) {
        for (i in 0 until 2) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                repeat(4) {
                    Box(
                        modifier = Modifier
                            .size(90.dp)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ){
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .background(Color.LightGray)
                        )
                    }

                }
            }
        }
    }
}

@Preview
@Composable
fun UserProfileScreenPreview() {
    val navController = rememberNavController()
    ProfileScreen(navController = navController)
}

