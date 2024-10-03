package com.example.farmdiary.farmDiary.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbDownOffAlt
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.ThumbUpOffAlt
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.farmdiary.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun FarmCoScreen(navController: NavController){

    val itemsFarmCo = listOf("Goods", "Machineries", "Labours")

//    Scaffold (
//        topBar = {
//            TopAppBarWithBackButton(title = "Farm Co", isHome = false) {
//            }
//        },
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = { /* TODO: Handle click */ },
//                shape = CircleShape,
//                containerColor = Color.Green
//            ) {
//                Icon(
//                    modifier = Modifier.size(50.dp),
//                    imageVector = Icons.Default.Add,
//                    contentDescription = "Add",
//                    tint = Color.White
//                )
//            }
//        }
//    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
        ) {

            val scrollState = rememberScrollState()
            
            Spacer(modifier = Modifier.height(90.dp))

            Row (
                modifier = Modifier
                    .wrapContentWidth()
                    .horizontalScroll(rememberScrollState())
            ){
                itemsFarmCo.forEach{ item ->
                    SectionOfFarmCo(text = item)
                    Spacer(modifier = Modifier.width(12.dp))
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column (
                modifier = Modifier.verticalScroll(scrollState)
            ) {
                ItemFarmCoScreen()
                ItemFarmCoScreen()
                ItemFarmCoScreen()
                ItemFarmCoScreen()
            }

        }

//    }

}

@Composable
fun SectionOfFarmCo(text: String){

    val backgroundColor = Color(0xFFEBEBEB)

    Box(
        modifier = Modifier
            .shadow(elevation = 1.dp, shape = RoundedCornerShape(20.dp))
            .wrapContentWidth() // The width will resize according to the text
            .height(28.dp) // Fixed height for the boxes
            .clip(RoundedCornerShape(20.dp))
            .border(
                BorderStroke(1.dp, color = backgroundColor),
                RoundedCornerShape(20.dp)
            )
            .background(Color.White)
            .padding(start = 15.dp, end = 15.dp), // Padding inside the box ,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FarmCoTopAppBar(){
    TopAppBar(
        title = {

            Box(modifier = Modifier.fillMaxWidth()){
                Row (
                    modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = null,
                        tint = Color.Green
                    )

                    Text(
                        text = "Back",
                        fontSize = 20.sp,
                        color = Color.Green,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Farm Co",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    )
}

@Composable
fun ItemFarmCoScreen() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier
            .background(Color.White)
            .padding(5.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                // Left part: Profile Picture and Post Info
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Circular Profile Image Placeholder (Replace with actual image)
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color.Black, shape = CircleShape)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    // Column for Title and Date
                    Column {
                        Text(
                            text = "Ipsum",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "2 Days Ago",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.Gray
                            )

                            Spacer(modifier = Modifier.width(4.dp))

                            // Clock icon
                            Icon(
                                imageVector = Icons.Default.AccessTime, // Use a clock icon
                                contentDescription = "Time",
                                tint = Color.Gray,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                }

                // Right part: Overflow Menu (Three dots)
                Box(
//                    modifier = Modifier.size(60.dp),
                    contentAlignment = Alignment.TopEnd
                ){
                    Icon(
                        imageVector = Icons.Default.MoreHoriz, // Overflow menu icon
                        contentDescription = "More options",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.TopEnd)
                    )
                }
            }



//            // Post Title
//            Text(
//                text = "Ipsum",
//                style = MaterialTheme.typography.bodySmall,
//                color = Color.Black
//            )
//            Text(
//                text = "2 Days Ago",
//                style = MaterialTheme.typography.bodySmall,
//                color = Color.Gray
//            )

            // Post Description
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed diam aliquip ex ea commodo consequat.",
                style = MaterialTheme.typography.bodySmall
            )

            // Image Placeholder (replace with actual image loading)
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .background(Color.LightGray) // Placeholder for image
                    .shadow(elevation = 10.dp)
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.vegetable),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }

            // Price and Category
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                // Left Side: Colored dots and text
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically) {
                    // Dots
                    ColorDot(Color(0xFF6A5ACD)) // Replace with your actual color codes
                    Spacer(modifier = Modifier.width(4.dp))
                    ColorDot(Color(0xFFEE82EE))
                    Spacer(modifier = Modifier.width(4.dp))
                    ColorDot(Color(0xFFD2691E))

                    Spacer(modifier = Modifier.width(8.dp))

                    // Text (e.g., "1,200")
                    Text(
                        text = "1,200",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }

                // Right Side: Price and Category
                Column(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center
                ) {
                    // Price Text
                    Text(
                        text = "Tk 528",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black
                    )

                    // Category Text
                    Text(
                        text = "Category: Vegetable",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }

            // Review and Interaction Buttons
//            Spacer(modifier = Modifier.height(8.dp))

            val items = listOf(
                CircleWithIconItem(Color(0xFF6A5ACD), Icons.Default.ThumbUpOffAlt),
                CircleWithIconItem(Color(0xFFD07655), Icons.Default.ThumbDownOffAlt),
                CircleWithIconItem(Color(0xFFCB6CE6), Icons.Outlined.ShoppingBag)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 0.dp, end = 8.dp, bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                // Left Side: Colored dots and text
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically) {

                    items.forEach { item ->
                        CircleWithIcon(item = item) // Replace with your actual color codes
                        Spacer(modifier = Modifier.width(4.dp))
                    }

                }


                // Category Text
                Text(
                    text = "8 Review",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )

//                // Right Side: Price and Category
//                Column(
//                    horizontalAlignment = Alignment.End,
//                    verticalArrangement = Arrangement.Center
//                ) {
//                    // Price Text
//                    Text(
//                        text = "Tk 528",
//                        style = MaterialTheme.typography.bodyLarge,
//                        color = Color.Black
//                    )
//
//                    // Category Text
//                    Text(
//                        text = "Category: Vegetable",
//                        style = MaterialTheme.typography.bodyMedium,
//                        color = Color.Gray
//                    )
//                }
            }
        }
    }

    Spacer(modifier = Modifier.height(5.dp))
}

data class CircleWithIconItem(
    val color: Color,
    val icon: ImageVector
)

@Composable
fun CircleWithIcon(
    item: CircleWithIconItem
){

    Box(
        modifier = Modifier
            .size(40.dp)
            .background(item.color, shape = CircleShape),
        contentAlignment = Alignment.Center
        
    ){
        Icon(
            imageVector = item.icon,
            tint = Color.White,
            contentDescription = null
        )
    }
}

@Composable
fun ColorDot(color: Color) {
    Box(
        modifier = Modifier
            .size(12.dp)
            .background(color, shape = CircleShape)
    )
}


@Preview(showBackground = true)
@Composable
fun FarmCoScreenPreview(){
//    ItemFarmCoScreen()
//    FarmCoTopAppBar()

//    Row {
//        SectionOfFarmCo(text = "Goods")
//        Spacer(modifier = Modifier.width(12.dp))
//        SectionOfFarmCo(text = "Machineries")
//        Spacer(modifier = Modifier.width(12.dp))
//        SectionOfFarmCo(text = "Labours")
//    }

    val navController = rememberNavController()

    FarmCoScreen(navController)
}
