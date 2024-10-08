package com.example.farmdiary.farmDiary.presentation.screen

import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.example.farmdiary.AppRouteActivity
import com.example.farmdiary.R
import com.example.farmdiary.farmDiary.presentation.navigation.Screens
import kotlinx.coroutines.delay

@Composable
fun SocialButton(icon: Int) {
    OutlinedButton(
        onClick = { /* TODO: Handle social login */ },
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        modifier = Modifier.size(height = 60.dp, width = 100.dp),
    ) {
//        Text(icon) // You can replace this with Icon Composables for actual logos

        Icon(
            modifier = Modifier.height(24.dp),
            painter = painterResource(id = icon),
            contentDescription = null
        )

    }
}


@RequiresApi(Build.VERSION_CODES.P)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginRegisterScreen(navController: NavController) {
    var isLoginSelected by remember { mutableStateOf(true) }  // Toggle between Login and Register
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue("")) }
    var address by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by remember { mutableStateOf(false) }
    var isSplashScreenFinished by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val animatedOffsetY by animateDpAsState(
        targetValue = if (isSplashScreenFinished) (90).dp else 0.dp,
        animationSpec = tween(durationMillis = 1000) // Animation duration 1 second
    )

    val animatedOffsetX by animateDpAsState(
        targetValue = if (isSplashScreenFinished) (-90).dp else 0.dp,
        animationSpec = tween(durationMillis = 800) // Animation duration 1 second
    )

    val animatedOffsetXDiary by animateDpAsState(
        targetValue = if (isSplashScreenFinished) (85).dp else 0.dp,
        animationSpec = tween(durationMillis = 800) // Animation duration 1 second
    )

    val animatedOffsetYDiary by animateDpAsState(
        targetValue = if (isSplashScreenFinished) (10).dp else 0.dp,
        animationSpec = tween(durationMillis = 800) // Animation duration 1 second
    )

    val textAnimation by animateFloatAsState(
        targetValue = if (isSplashScreenFinished) 45f else 60f,
        label = "T",
        animationSpec = tween(800)
    )
    val animateImageAlpha by animateFloatAsState(
        targetValue = if(!isSplashScreenFinished) 0f else 1f,
        label = "nothing",
        animationSpec = tween(1500)
    )

    val animateForLogin by animateFloatAsState(
        targetValue = if(isSplashScreenFinished) 1f else 0f,
        label = "nothing",
        animationSpec = tween(1300)
    )

    val animatedHeight by animateFloatAsState(
        targetValue = if(isSplashScreenFinished) .3f else 0f,
        label = "nothing",
        animationSpec = tween(1200)
    )



    var offset by remember {
        mutableStateOf(Offset(0f, 0f))
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.Center
    ) {

        LaunchedEffect(key1 = true) {
            delay(1000)
            isSplashScreenFinished = true
        }

//        if (!isSplashScreenFinished) {
//            Spacer(modifier = Modifier.fillMaxHeight(animatedHeight))
//        }
//         App Title
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .offset(animatedOffsetX, animatedOffsetY),
            text = "Farmer's",
            fontSize = textAnimation.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF228B22),
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .offset(animatedOffsetXDiary, animatedOffsetYDiary)
                .onGloballyPositioned { layoutCoordinates ->
                    offset = layoutCoordinates.positionInRoot()
                    println(offset)
                },
            text = "Diary",
            fontSize = textAnimation.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF228B22),
            textAlign = TextAlign.Center
        )

        AnimatedVisibility(
            visible = !isSplashScreenFinished,
            modifier = Modifier.graphicsLayer {
//                alpha = animateImageAlpha
            },
            exit = fadeOut(animationSpec = tween(300))
        ) {
            Column (
                modifier = Modifier,
                verticalArrangement = Arrangement.Bottom
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(.6f),
                    painter = painterResource(id = R.drawable.splash_screen),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }
        }


        AnimatedVisibility(
            visible = isSplashScreenFinished,
            modifier = Modifier.graphicsLayer {
                alpha = animateForLogin
            },
            fadeIn(animationSpec = tween(1200)),
            fadeOut(animationSpec = tween(1200))
        ) {
            // Toggle between Login and Register
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(Color(0xFF228B22)),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    OutlinedButton(
                        onClick = { isLoginSelected = true },
                        border = if (isLoginSelected) BorderStroke(2.dp, Color(0xFF228B22)) else null,
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = if (isLoginSelected) Color.White else Color(0xFF228B22),
                            contentColor = if (isLoginSelected) Color(0xFF228B22) else Color.White
                        ),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Log in")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedButton(
                        onClick = { isLoginSelected = false },
                        border = if (!isLoginSelected) BorderStroke(2.dp, Color(0xFF228B22)) else null,
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = if (!isLoginSelected) Color.White else Color(0xFF228B22),
                            contentColor = if (!isLoginSelected) Color(0xFF228B22) else Color.White
                        ),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Register")
                    }
                }


                // Login Form with animation
                AnimatedVisibility(
                    visible = isLoginSelected,
                    modifier = Modifier
                        .graphicsLayer {
                            alpha = animateImageAlpha
                        }
                ) {
                    Column {
                        // Email TextField
                        // Email TextField
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("Email address") },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth(),
                            singleLine = true,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFFD8DADC),    // Set color when TextField is focused
                                unfocusedBorderColor = Color(0xFFD8DADC)   // Set color when TextField is unfocused
                            )
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Password TextField with visibility toggle
                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text("Password") },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            singleLine = true,
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                val icon = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                    Icon(icon, contentDescription = if (passwordVisible) "Hide password" else "Show password")
                                }
                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFFD8DADC),    // Set color when TextField is focused
                                unfocusedBorderColor = Color(0xFFD8DADC)   // Set color when TextField is unfocused
                            )
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Remember me and Forgot password row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Checkbox(
                                    checked = false,
                                    onCheckedChange = {}
                                )
                                Text(text = "Remember me")
                            }
                            TextButton(onClick = { /* TODO: Forgot password functionality */ }) {
                                Text(text = "Forgot password?")
                            }
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        // Login or Register Button
                        Button(
                            onClick = {
                                val intent = Intent(context , AppRouteActivity::class.java)
                                context.startActivity(intent)

                                Log.d("LOGIN","CLICKED $isLoginSelected")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF228B22)),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "Log in",
                                color = Color.White,
                                fontSize = 18.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(35.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Divider(modifier = Modifier
                                .weight(1f)
                                .height(2.dp))
                            // Or login with social media
                            Text(
                                text = "Or Login with",
                                modifier = Modifier
                                    .padding(8.dp)
                                    .weight(1f),
                                textAlign = TextAlign.Center
                            )

                            Divider(modifier = Modifier
                                .weight(1f)
                                .height(2.dp))
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Social Media Buttons
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            SocialButton(icon = R.drawable.facebook)
                            SocialButton(icon = R.drawable.digitalmonitoring_image)
                            SocialButton(icon = R.drawable.apple)
                        }
                    }
                }


                // Register Form with animation
                AnimatedVisibility(
                    visible = !isLoginSelected,
                    modifier = Modifier
                        .graphicsLayer {
                            alpha = animateImageAlpha
                        }
                ) {
                    Column {
                        // Email TextField
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("Email address") },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            singleLine = true
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Create Password TextField
                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text("Create a password") },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            singleLine = true,
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                val icon = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                    Icon(icon, contentDescription = if (passwordVisible) "Hide password" else "Show password")
                                }
                            }
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Confirm Password TextField
                        OutlinedTextField(
                            value = confirmPassword,
                            onValueChange = { confirmPassword = it },
                            label = { Text("Confirm password") },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            singleLine = true,
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                val icon = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                    Icon(icon, contentDescription = if (passwordVisible) "Hide password" else "Show password")
                                }
                            }
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Address TextField
                        OutlinedTextField(
                            value = address,
                            onValueChange = { address = it },
                            label = { Text("Address") },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            singleLine = true
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Create account Button
                        Button(
                            onClick = { /* TODO: Handle registration */ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF228B22)),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "Create account",
                                color = Color.White,
                                fontSize = 18.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Terms and Conditions
                        Text(
                            text = "By creating an account or signing you agree to our Terms and Conditions",
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }
                }
            }

        }

    }

}

@RequiresApi(Build.VERSION_CODES.P)
@Preview(showBackground = true)
@Composable
fun LoginRegisterScreenPreview() {
    LoginRegisterScreen(rememberNavController())
}




