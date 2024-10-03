package com.example.farmdiary.farmDiary.presentation.screen

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Pets
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.example.farmdiary.R
import com.example.farmdiary.farmDiary.presentation.navigation.Screens
import com.google.accompanist.drawablepainter.rememberDrawablePainter


@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun Home(navController: NavController){

    val climate = "https://s3-alpha-sig.figma.com/img/9625/9b46/2bbbce5a4428bb03bf0ccc9a0d14ea40?Expires=1728864000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=G1~jOvDuZeDAOgWPLXi-CP6XfJcV2Q1X0bFQxU~N2sUhC98Nok9cptQ7ebkypAl0qXZl6tl8eiBW-c5KUWSX~lTrC0NwBX8yjbyvuEgXHkKJU2sqh9HzQBKRdScvSyfdHO2hBGnmKFU~9pGhqOAPSDBj1BA7mnakbE-AyBWi2zcgovjPdEo5IHh-pBkn0L~FJs8RAZ9jnN62I6234hC9uDsnd1DPAs1dEYSzleeA3OrM8OLr-PQpX9lrKjkQFqtN~6HrTpIdylb4BzkkE88stS~Tdoi-s0svN~MkHSxecJEgxaFMXsXzi3lCPaOmOQ2CKY0OEGKtbK7yPoE3hALHOQ__"
    val waterManagement = "https://s3-alpha-sig.figma.com/img/411e/f42c/a4b2e0b9ef97f3c944a47df78896b066?Expires=1728864000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=O9Uhhid5JsmxS3kGTvsyPyy0QaZOGN3qsLOe3JhN7x8H3d8YZHYMRcqr1hLhjWuspXFrkwZPJ2bHWqAGk3BnyZkwjetyawQdQEDfnT3zMlxCoVexzRFrPxB9FfCv7f9sREn~IGEyHG53Tr8vQfBKnfIMwNVPla70~45zg~IwC0MNKs-~rDNuKqg9oBdkGia7FWXKEooH3tY-~Ze2wSm4OgjXlRtSUWtxg80JZzO-agkv9mYAZqKVMamVnBt4yb6gGjMrbto~H6BhKQ3a4wrxwnWxNsrFbdpXN8cYxt2zO52X8huGkRf-6rnleVfwQ7tPkSMiTJyL2EoH3zaZ2wKMnw__"
    val fishFarming = "https://s3-alpha-sig.figma.com/img/2f1f/5f59/5dc9ab65a0e91549c1719caa3ab6a55c?Expires=1728864000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=W2Bv2L7Tg21xUhcuR3YCEwMNBL29I2w-e-3a66Qxasi0xQygSkV7b3hIKXnBVB3DsepK2l7R0ETobc7SjfPlPVn5w8DlhNhnVTJgEc2B4OjKaQYfVjoiNG13NEZF1Kiz0SfWXP~1cwbxMntg69Rbv1B~JohTdYxBQ0D-VQ1kjWKmPoI7EmAkRfPRWItAVOnYGPX7UzU46oirV8aAeBCbo3yfH7Pm-FVrKXi-Nc8UW58VcqAXXwBJmiRBgUnoBLYJXX9f5mjZ95IrqRj~DbfXtFScqEyWkTDLtFpKcISejZSrkTB1Sp~~k6XkhjAOWdeBM3t1XypsGfIE01v73wnOWQ__"
    val cropHealthMonitoring = "https://s3-alpha-sig.figma.com/img/7b67/c2ff/f98d04aa9e30d2bffbe2088cdf14900a?Expires=1728864000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=R-F7IMUtDhJcXRNkQ0JLHo2lojAZFB1HwfpYgmvN6VhJ8VAbvxQRIE2EJdpNF5vrRJd538YQvXplZmDqF71EK3XD453J8Tt4UKTu~3H3Fel8EhLD2xjeOX1K3iMp~c~ggDo7y924Iek2jDVGdXPn8G4YdwchX9VjEhVp6LbXys~tA8TEO9vOQHBfA34w2bDxLqglle0xgsgQ365cdcwmlyVhXwF9JrPUmIMK5iV~j~9dOM2JAHDwmTc4KStz5bIbwMP5L38Q-ifHU-Imp1sgyLIrZsvNHwBgmAQLMeHdgTd~As5Lc~x~4hiuqXmvgzwo9~jhPwx5FEITpOHBOT7YdA__"
    val manageStore = "https://s3-alpha-sig.figma.com/img/7c1c/0092/dbc82633216a3020cf22296c11a789a7?Expires=1728864000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Vn-DFzWH3e5QJvL01QSTufRwhC3ExcLePU6BfYoYXUuEP414RGlJyu40-wR6IO6O3ZItv49nVbSW5UBnaFs2SPzZNEKFHWbIN4X43na7ZxpvAZeGsIMaXhmdwSG6aGcitv2hPq5jBFa-NeOu1ytdP7MhtJK53BfOiYoZ5HQBnK-Fb1Egcz2hTjgQyt9oyJAXlZnZ8~IqSYRSoVfltgwMBPlOAQra0ZRMWwtuM02Oo4iL9qWKONo4CpA4Xm5~zjoJK8cIc6plFtBlf7-Oq3PWsIjDkWCtHnXtAxciD9HAq9qEqgESh9UL6MkFGgvQduFD42BBRWkpqs2gyhBPZaWyXA__"
    val airQuality = "https://s3-alpha-sig.figma.com/img/3e78/b0ac/4de68bb023bdc7d0b0607319db1bf279?Expires=1728864000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=YpZIiXvSGLXWromUfQ0w6i3URC7tILlhaQN5SWotVWvMAQNpqtFTtnhbfklEWlrLsmp-y-P6f1OcuA-ThYvun8nZD1B6A-4VShVZHaOm0Mz8lPEwd-kHSkNszgyNrUdcwEnyIoD1lkxOw44vfPvFFqcgfkxqiFSfk3ngirZ44IdV9XtbTlcsnK3XIznfJE08G7wRspVPZkWnpieblslsM91Ncma3EosrYuEEFDE8E2OrU-0xg1zWAU0OEjCM2ZoihiYBlTb58sZ-lGcj5lLOFOLsFOPEVQMF20QC4Uv5gu~S7GMo9Geddl-dsKzgwViUPde4bxldjeI1FGQgyJJLQg__"
    val stormAlert = "https://s3-alpha-sig.figma.com/img/4dbd/3c09/dc7340974b148e37b51a75b016866ee1?Expires=1728864000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=jhgcUOB30g2otR9emunm47YM9kV10C94umnKWEi~omqK-9JFjJxOrpJtFylVgn~GhjBIkJvrsH0cf0v6XJKGPrXU6Z73PtT89G0v4rLxRMJA83QcsvrSgxhFmI0lbHzSl2TGd-qQxpoRSRNSYPmDhE~7-j3tz1IphWG9teBXJ43Pw3x64dqGh-W~-H3eq27TVR5lr3oGTxTmp39E~COyUQ-jNz0kJRUQaJi~s0gdBZg3gSx9GcSGeFVYXDrZLR8P55vz8sTEPdw6OPvK7K3iUDuScXrl4KutwWu6FgcRV8hG5xMWspomXI76iiJpsxK-gddVXv2UjIlfVemoSV5PfA__"
    val weatherForecast = "https://s3-alpha-sig.figma.com/img/d690/01f3/7fe9e3e2a17803e3c61429ed6328c773?Expires=1728864000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=IGKODpIxcoDgR0cp0~qfVLFqbvZX0C1DYUmvYEdqd-ZeoDRcXdbkh6fVn46kLpBcdOlwTbxj8teKe64ZCAGGJVkiQlNJRb8vPxQyNbf06A6EnWa9ZGJ8zC6gVeAHVwcNxSo3MNuCwL3xb5FzLQfcYTDL~m4-vVvPKCMDQzrTedRG5FZn0rC4Lg223Xi-RreLUgK8QKuuKWU5Zcaw423ZL12oZ9ykRMwTz5Il6Bk6M1mxfJJETexb-qNv4whtIGag3Mi6YaluZWVXQXTaE97DrD50M4D2m2Xd7hzAFcrkGBl3fxlJQmWuE3unHXY-b8oIijIe8EPZ~t9VhgK0zZeLMg__"
    val pestDisease = "https://s3-alpha-sig.figma.com/img/0c38/e8e5/87eebe32939fea1fdbf15734b1981727?Expires=1728864000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=IkMB7zcvV8kMulbLIP1C5Q6dkKstngVwFC59fvgN-2HIj7w6ZTAtrWI-g2jtcnmn7fpQBMiCw8WM~3uFWhcGv8A~SppN639EKkXR4iUm5SIUGzc~bc0QNXA~K9brUy4Yzg8x~hSumPMS40Tm7g-~S9l5O8ogUkcnFhR6Qg67-endt3b90-1Jm-zBiwr47atV4~XVeVuHDRUMUMtv~F5vNnrSPcvPtgf7wqlApa5raa2MLTuZ5DmMcXbSiM8YNyHm9NPvSBvA325vhPIECv29BDYIXsFWjWLS7GT8gE65h0Al0JJhRwQq-IqQyq3W3Z8j3aCbr86El-HaY4~5Zsi9Tg__"
    val soilTemperature = "https://s3-alpha-sig.figma.com/img/33e5/295b/23475b4738ee38f74655e927f7f9a51d?Expires=1728864000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=J-yZbLUBO7LRTQHDSyjTWQAgw-MLOOMJLXlmctkcUCJ-xdcj8bQB9NxBH5maHHrJrkIgdJEQIZeXKVcU7yUalNFBe1OI3znsB9poOrFDhOOgtNhYbUobrNyZYmtCA1QSG3Qv5E~FKJcJdLbEanjLwHn~hQ32zogup6KrMN18lTlBzo0SXAjOcsKySmDKRxdRzO6w34wMarV15a3u8kWw~3gJ3lVdPO0SodKUJHhBLKGTy0MTsEd-7kE2jTDrrppgUsy25VGvdZszWtKX-EYsjaElIgqdWr~HIJK-u5Q~2uxlVPJXnXlE674UDauM7PXQLNhqcNPwt6nIXRFarJ38YQ__"


    val lightGreen = Color(0xFFCADDD1)
    val items1 = listOf(
        ContentItem( "Climate Change",climate, lightGreen,navController),
        ContentItem("Water Management",waterManagement, lightGreen,navController),
    )

    val items2 = listOf(
        ContentItem( "Crop Health Monitoring",cropHealthMonitoring,lightGreen,navController),
        ContentItem( "Fish Farming",fishFarming,lightGreen,navController),
    )

    val items3 = listOf(
        ContentItem( "Manage Store",manageStore,lightGreen,navController),
        ContentItem("Soil Temperature Monitoring",soilTemperature, lightGreen,navController),
    )

    val items4 = listOf(
        ContentItem( "Pest & Disease Prediction",pestDisease, lightGreen,navController),
        ContentItem("Weather Forecasting",weatherForecast,  lightGreen,navController),
    )

    val items5 = listOf(
        ContentItem( "Storm Alert",stormAlert, lightGreen,navController),
        ContentItem("Air Quality",airQuality, lightGreen,navController),
    )

    val scrollState = rememberScrollState()

//    Scaffold (
//        topBar = {
//            TopAppBarWithBackButton(title = "Home", isHome = true) {
//            }
//        }
//    ) { innerPadding ->
//
//        Log.d("INNER", innerPadding.toString())


        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(start = 10.dp, end = 10.dp)
        ) {

            Spacer(modifier = Modifier.height(90.dp))
            TextAndNotification()
            Spacer(modifier = Modifier.height(20.dp))
            SearchBar()
            Spacer(modifier = Modifier.height(20.dp))
            CategoryRow(items = items1, Color(0xFFD1EBDB))
            Spacer(modifier = Modifier.height(20.dp))
            CategoryRow(items = items2,Color(0xFFD1EBDB))
            Spacer(modifier = Modifier.height(20.dp))
            CategoryRow(items = items3,Color(0xFFD1EBDB))
            Spacer(modifier = Modifier.height(20.dp))
            CategoryRow(items = items4,Color(0xFFD1EBDB))
            Spacer(modifier = Modifier.height(20.dp))
            CategoryRow(items = items5,Color(0xFFD1EBDB))
            Spacer(modifier = Modifier.height(140.dp))


//        }
    }
}

@Composable
fun FloatingButton(
    modifier: Modifier = Modifier
){

    FloatingActionButton(
        modifier = Modifier
            .size(65.dp)
            .offset((-1).dp, 95.dp)
            .clip(shape = CircleShape),
        onClick = { /* Handle floating button click */ },
        containerColor = Color(0xFFD1EBDB),
    ) {
        Icon(
            modifier = Modifier.size(50.dp),
            imageVector = Icons.Default.CameraAlt, // Space icon for the floating button
            contentDescription = null,
            tint = Color.Black
        )
    }
}

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavController
){

    val color = Color(0xFF007E2F)
    val color1 = Color(0xFF939393)


    val items = listOf(
        BottomNavItem(Icons.Outlined.Home, "Home", Icons.Filled.Home),
        BottomNavItem(Icons.Outlined.Groups, "Farm Co", Icons.Filled.Groups),
        BottomNavItem(Icons.Outlined.Pets, "Space", Icons.Filled.Pets),
        BottomNavItem(Icons.Outlined.Chat, "Chat Bot", Icons.Filled.Chat),
        BottomNavItem(Icons.Outlined.AccountBox, "Profile", Icons.Filled.AccountBox)
    )

    val animateNavItem : Dp by animateDpAsState(
        targetValue = 20.dp,
        animationSpec = tween(500),
        label = "Item"
    )

    BottomAppBar (
        containerColor = Color.White,
        contentColor = Color.Green,
        modifier = modifier
            .background(Color.White)
            .shadow(elevation = 10.dp)
    ) {

        // Get screen width dynamically
        val screenWidth = LocalConfiguration.current.screenWidthDp.dp

        // Calculate item width by dividing screen width by the number of items
        val itemWidth = screenWidth / (items.size)

        Log.d("MEASUREMENT","$screenWidth and $itemWidth")

        var selectedItemIndex by remember { mutableStateOf(0) }
        val animatedPosition by animateDpAsState(targetValue = selectedItemIndex * itemWidth) // Item width + padding

        Column (
            modifier = modifier
                .align(Alignment.Top)
        ) {
            Box(
                modifier = Modifier
                    .offset(x = animatedPosition)
                    .size(width = itemWidth - 10.dp, height = 4.dp) // Width depends on item size
                    .background(color = color, RoundedCornerShape(2.dp))

//                    .align(Alignment.Top)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Box (
                modifier = modifier
                    .fillMaxWidth(),
            ) {

            // Animated rectangle moving under the selected item

                Spacer(modifier = Modifier.height(10.dp))

                Row (
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    items.forEachIndexed { index, item ->

                        Box(modifier = Modifier
                            .weight(1f)
                            .fillMaxSize(),
                            contentAlignment = Alignment.TopCenter
                        ){
                            Column (
                                modifier = modifier
                                    .fillMaxSize()
                                    .clickable {
                                        if (index != 2) {
                                            selectedItemIndex = index
                                        }
                                        when (index) {
                                            0 -> navController.navigate(Screens.ScreenHomeRoute.route)
                                            1 -> navController.navigate(Screens.ScreenFarmCoRoute.route)
                                            2 -> navController.navigate(Screens.ScreenCameraRoute.route)
                                            3 -> navController.navigate(Screens.ScreenChatBotRoute.route)
                                            else -> navController.navigate(Screens.ScreenProfileRoute.route)
                                        }
                                    },
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceEvenly,
                            ) {
                                if (item.label == "Space"){
                                    Spacer(modifier = Modifier.width(itemWidth))
                                }else {
                                    Icon(
                                        modifier = modifier.size(30.dp),
                                        imageVector = if (selectedItemIndex == index) item.icon1 else item.icon,
                                        contentDescription = null,
                                        tint = if (selectedItemIndex == index) color else color1
                                    )
                                    Text(
                                        text = item.label,
                                        color = if (selectedItemIndex == index) color else color1,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp
                                    )
                                }
                            }
                        }
                    }

                }


            }

            Box(
                modifier = Modifier
                    .size(100.dp, 5.dp)
                    .background(Color.Black)
                    .clip(shape = CircleShape)
            )


        }
    }

}

@Composable
fun TextAndNotification(){
        val itemCount by remember {
            mutableIntStateOf(0)
        }
        
        Box (
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Box (
                modifier = Modifier
                    .size(50.dp)
                    .clip(shape = CircleShape)
                    .padding(2.dp),
                contentAlignment = Alignment.Center

            ) {
                BadgedBox(
                    badge = {
                        Badge(
                            modifier = Modifier
                                .size(15.dp)
                                .offset((-12).dp, 2.dp),
                            containerColor = Color(0xFFFF1010)

                        ){
                            Text(text = "3", color = Color.White)
                        }
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(35.dp),
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = null)
                }
            }
        }



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {

    var text by remember {
        mutableStateOf("")
    }

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(top = 10.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box (
            modifier = Modifier
                .weight(1.5f)
                .padding(5.dp),
            contentAlignment = Alignment.CenterStart
        ) {
//            Box (
//                modifier = Modifier
//                    .size(60.dp)
//                    .clip(shape = CircleShape)
////                    .background(Color.Cyan)
//                    .padding(2.dp),
//                contentAlignment = Alignment.Center
//
//            ) {
//
//            }
            Image(
                modifier = Modifier.size(35.dp),
                painter = painterResource(id = R.drawable.img),
                contentDescription = null
            )
        }

        val colorBorder = Color(0xFFD8DADC)

        Card (
            modifier = Modifier
                .weight(8f)
                .align(Alignment.CenterVertically)
                .border(
                    BorderStroke(1.dp, colorBorder),
                    RoundedCornerShape(5.dp)
                )
                .clip(RoundedCornerShape(12.dp)),
            colors = CardDefaults.cardColors(Color.White),
//            shape = RectangleShape,
            elevation = CardDefaults.cardElevation(20.dp)
        ) {

            TextField(
                value = text,
                onValueChange = {text = it},
                placeholder = { Text(text = "Search..") },
                shape = CircleShape,
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize(),
                leadingIcon = {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = Icons.Default.Mic,
                        contentDescription = null
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = Color.Transparent
                )
            )
        }

    }

}


@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun CategoryRow(items: List<ContentItem>, color: Color) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items.forEach { item ->
            CategoryItem(item)
//            Spacer(modifier = Modifier.width(6.dp))
        }
    }
}

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun CategoryItem(item: ContentItem) {

    val lightGreen = Color(0xFF7CB892)
//    val lightPastelGreen = Color(0xFFBFE1CC)
    val colorBorder = Color(0xFFD8DADC)


    val colorBrush = Brush.verticalGradient(
        listOf(Color.White,Color.White,Color.White, Color.White,item.color, item.color))


    Box (
        modifier = Modifier
            .size(160.dp)
            .border(
                BorderStroke(1.dp, colorBorder),
                RoundedCornerShape(20.dp)
            )
            .clip(RoundedCornerShape(20.dp))
            .shadow(
                elevation = 55.dp,
                shape = RectangleShape
            ).clickable {
//                if (item.label == "Manage Store"){
                    item.navController.navigate(Screens.ManageStoreRoute.route)
//                }
            },

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clickable { /* TODO: Handle click */ }
                .background(brush = colorBrush)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

//            val gif = "https://s3-alpha-sig.figma.com/img/9625/9b46/2bbbce5a4428bb03bf0ccc9a0d14ea40?Expires=1728864000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=G1~jOvDuZeDAOgWPLXi-CP6XfJcV2Q1X0bFQxU~N2sUhC98Nok9cptQ7ebkypAl0qXZl6tl8eiBW-c5KUWSX~lTrC0NwBX8yjbyvuEgXHkKJU2sqh9HzQBKRdScvSyfdHO2hBGnmKFU~9pGhqOAPSDBj1BA7mnakbE-AyBWi2zcgovjPdEo5IHh-pBkn0L~FJs8RAZ9jnN62I6234hC9uDsnd1DPAs1dEYSzleeA3OrM8OLr-PQpX9lrKjkQFqtN~6HrTpIdylb4BzkkE88stS~Tdoi-s0svN~MkHSxecJEgxaFMXsXzi3lCPaOmOQ2CKY0OEGKtbK7yPoE3hALHOQ__"


            val context = LocalContext.current

            val gifPainter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(context)
                    .data(item.gif)
                    .size(Size.ORIGINAL)
                    .decoderFactory(GifDecoder.Factory())
                    .build()
            )

            Box(modifier = Modifier
                .weight(8f)
                .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {

                Image(
                    painter = gifPainter,
                    contentDescription = "Loading GIF",
                    modifier = Modifier.size(100.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Box (
                modifier = Modifier
                    .weight(4f)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = item.label,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithBackButton(
    title: String,
    isHome: Boolean,
    onBackPressed: () -> Unit
) {
    TopAppBar(
        title = {

            Box(
                modifier = Modifier
                .fillMaxWidth(if (isHome) 1f else .7f),
                contentAlignment = if (isHome) Alignment.CenterStart else Alignment.Center
            ){
                Text(
                    text = title,
                    fontSize = 30.sp,
                    color = Color(0xFF007E2F),
                    fontWeight = FontWeight.Bold
                )
            }
//            if (isHome) {
//                Text(text = "Farmer's Diary") // Home title
//            } else {
//                Box(
//                    modifier = Modifier.fillMaxWidth(),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(text = title) // Title in the center for other screens
//                }
//            }
        },
        navigationIcon = {
            if (!isHome){
//
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { onBackPressed() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = "Back"
                        )
                    }
                    Text(text = "Back")
                }
            } else null // No back icon for the Home screen
        }
    )
}

@RequiresApi(Build.VERSION_CODES.P)
fun createAnimatedImageDrawableFromImageDecoder(context: Context, uri: Uri): AnimatedImageDrawable {
    val source = ImageDecoder.createSource(context.contentResolver, uri)
    val drawable = ImageDecoder.decodeDrawable(source)
    return drawable as AnimatedImageDrawable
}



@RequiresApi(Build.VERSION_CODES.P)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){

    val navController = rememberNavController()


    Home(navController)
//    SearchBar()
//    TextAndNotification()

}

data class ContentItem(
    val label: String,
    val gif : String,
    val color: Color,
    val navController: NavController
)


data class BottomNavItem(
    val icon: ImageVector,
    val label: String,
    val icon1: ImageVector
)