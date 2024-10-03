package com.example.farmdiary.farmDiary.presentation.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.farmdiary.R


@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun ManageStoreScreen(navController: NavController){

    val digitalMonitoring = "https://s3-alpha-sig.figma.com/img/043a/7036/476668fdac6c63ffe16ea6f04390979c?Expires=1728864000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=FybHC4OJWq0QG~1fY7sNCWWMAuB0gJoDnUJPH0mQoqhbRry2rxCYMrq2CWVTQpaFypSpybLBaRQMhNQnwCfuph8MjVr-K9o-H3KikOi1v5D7DP3Xm5vFlV4QzKbnImhFd2FQ7eLVR5sSYbbzPahcrFX~G95m4-~-m0tyA9gLkOsUQG0GTvd6bmCRMi7wzHYXeKbrD9DAS4BsgcdNt1VyRFvulYQ1xvnD1Bp3vhnlJ0WWBcUr4AoHZ70ZdLJTRFXFKydJyoHXPrMxQd3VaKCXmNBDl81eCigflc7Gz03lg3nMCXwcF1c5o4crM-w-5LF23hOwy7tdfH0UxTbCwU1ACw__"
    val liveLocationShare = "https://s3-alpha-sig.figma.com/img/dda6/57a1/ba5728502d1d11d4db8885ba11229838?Expires=1728864000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Gi34UM9XYAI0APhPSjqAdTEsNMq2GbhwRS8~l4oTGgx6jcLCbZOLRSmb~73xytkz8juJXFLYkBW-8-aBdud1jB4wD4yiIsNMn2VEe10BtIY8E3LU1kT9~o8LcZMC72ebFQZ3EhNiw6DLAc68ORlWrCh5wRhEPLDXWstw1L5tPFO56wIgkgWUBHT1p3igRGGbv0Iow3u6jbiqVzdEHhzCWOZ9j1ruLs6rWqovOWk1-se5Hq4Tz-u1K9H~R3QHdrPik8NpgDsvDDcZX99IBOKi-6nDQzONe6zN8skbWnBrCdipLWQjvoMa-KSLCbOMH2vdGddaPvL~npcarddg7S6PVQ__"
    val smartSecurity = "https://s3-alpha-sig.figma.com/img/f1f0/6efd/aa857e9e068b47db830277cc83cf2c1f?Expires=1728864000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=ZPCgLHGxXL3j2zdwJLZtcQEpLaBoDlyA4WOpJaL4W5bWGOpDu1O0Amm1POx9Eb46HoOgZ7jNbXgpWSPPUaH-YDSShhKWd~fjFs9CZFVuwJu-PwQK6gTyRV-yMO9vt-iDwQkF4ByrrNK2k43Zvh3TtFHxWJzOnqSktK2Pm7yc7dNzST-XXGCo9WJPZaNTQFuWhgWENxtWiIE--O30Uq1Wxul-Wh~i47g0tUzIQuaSoFAVj7CNi-gxXqRN5LGLbAk2ffFiHTI-XOtV9OT7-6Twycs3A4XE3i3IUP65ikl0pkbB6B~EH0-I3mfMryl3Hz11qYwTxNZHiyWe7R9PJ8R8bw__"
    val items1 = listOf(
        ContentItem( "Digital Monitoring",digitalMonitoring, Color(0xFF7CB892), navController),
        ContentItem("Live Location Share",liveLocationShare, Color(0xFF7CB892),navController),
    )

    val items2 = listOf(
        ContentItem( "Smart Security",smartSecurity, Color(0xFF7CB892),navController),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, top = 80.dp, end = 10.dp)
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

        Spacer(modifier = Modifier.height(80.dp))
        CategoryRow(items = items1, Color.White)
        Spacer(modifier = Modifier.height(30.dp))
        CategoryRow(items = items2, Color.White)

    }
}

@RequiresApi(Build.VERSION_CODES.P)
@Preview(showBackground = true)
@Composable
fun ManageStoreScreenPreview(){
    val navController = rememberNavController()
    ManageStoreScreen(navController)
}

