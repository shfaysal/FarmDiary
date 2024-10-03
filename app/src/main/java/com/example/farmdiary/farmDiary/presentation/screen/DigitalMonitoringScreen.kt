package com.example.farmdiary.farmDiary.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CellTower
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.farmdiary.R

@Composable
fun DigitalMonitoringScreen(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, top = 5.dp, end = 10.dp)
    ) {

        Box (
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(shape = RoundedCornerShape(30.dp))
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(
                    id = R.drawable.digitalmonitoring_image
                ),
                contentScale = ContentScale.FillWidth,
                contentDescription = null
            )

        }

        Spacer(modifier = Modifier.height(30.dp))

        DigitalMonitoringValue()
        DigitalMonitoringValue()
        DigitalMonitoringValue()

    }

}

@Composable
fun DigitalMonitoringValue(
    items : List<DigitalMoniItem>? = null
){
    val backgroundColor = Color(0xFFF3F4EE)

    Box (
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Row (
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box (
                modifier = Modifier.weight(2f),
                contentAlignment = Alignment.Center
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .weight(1f)
                            .size(32.dp),
                        imageVector = Icons.Default.CellTower,
                        contentDescription = null
                    )

                    Box(
                        modifier = Modifier
                            .weight(2f)
                            .fillMaxSize(),
                        contentAlignment = Alignment.CenterStart
                    ){
                        Text(
                            text = "Carbon dioxide level",
                            fontSize = 14.sp
                        )
                    }

                }

            }
            Text(
                modifier = Modifier
                    .weight(1f),
                text = "390ppm",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

    Spacer(modifier = Modifier.height(20.dp))

}

data class DigitalMoniItem(
    val image: ImageVector,
    val text: String,
    val temperature: String
)


@Preview(showBackground = true)
@Composable
fun DigitalMonitoringScreenPreview(){
//    DigitalMonitoringValue()
    val navController = rememberNavController()

    DigitalMonitoringScreen(navController)
}