package com.example.farmdiary.farmDiary.presentation.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.farmdiary.R

@Composable
fun UserProfileScreen(navController: NavController) {

    Column {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center // Center content inside the box
        ) {
//            Canvas(modifier = Modifier.size(width = 200.dp, height = 100.dp)) {
//                // Create a path for the curve
//                val path = Path().apply {
//                    moveTo(09f, 120f) // Start point at bottom start
//                    lineTo(0f, size.height) // Left vertical line to bottom
//                    lineTo(size.width, size.height) // Bottom right corner
//                    lineTo(size.width, 80f) // Right vertical curve to 80
//                    quadraticBezierTo(size.width / 2, size.height, 0f, 90f) // Curve from 0,90 to bottom center
//                }
//
//                // Draw the curved shape with a green gradient
//                drawPath(
//                    path = path,
//                    brush = Brush.verticalGradient(
//                        colors = listOf(Color(0xFF007E2F), Color(0xFF00B74D)),
//                        startY = 0f,
//                        endY = size.height
//                    )
//                )
//            }
//            // Add content inside the box if needed
//            Text(text = "Curved Box", color = Color.White) // Example text

            Text(text = "Profile")

        }


    }




}

@Composable
fun ProfilePhoto(){
    Box(modifier = Modifier
        .size(220.dp, 160.dp)){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Green),
                contentAlignment = Alignment.Center
                ){
                Image(
                    painter = painterResource(id = R.drawable.vegetable),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Mithun Modak",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,

            )

            Text(
                text = "codingsing.com|+0123242",
                fontSize = 12.sp,
            )
        }
    }
}

@Composable
fun OptionRow(text: String, secondaryText: String? = null, enabled: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Handle option click */ }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = text, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.weight(1f))
        if (secondaryText != null) {
            Text(text = secondaryText, style = MaterialTheme.typography.bodySmall)
        }
        if (enabled) {
            Switch(checked = enabled, onCheckedChange = { /* Handle switch change */ })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfilePreview(){
//    UserProfileScreen()
//    ProfilePhoto()
}