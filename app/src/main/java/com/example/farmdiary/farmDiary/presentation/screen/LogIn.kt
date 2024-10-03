package com.example.farmdiary.farmDiary.presentation.screen

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
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.example.farmdiary.R
import com.example.farmdiary.farmDiary.presentation.navigation.Screens


//@Composable
//fun LoginScreen() {
//    var email by remember { mutableStateOf(TextFieldValue("")) }
//    var password by remember { mutableStateOf(TextFieldValue("")) }
//    var passwordVisible by remember { mutableStateOf(false) }
//    var isLoginSelected by remember { mutableStateOf(true) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // App Title
//        Text(
//            text = "Farmer's Diary",
//            fontSize = 30.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color(0xFF228B22), // Dark Green Color
//            modifier = Modifier.padding(vertical = 24.dp)
//        )
//
//        // Toggle between Login and Register
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .clip(shape = RoundedCornerShape(8.dp))
//                .background(Color(0xFF228B22)),
//            horizontalArrangement = Arrangement.Center,
//        ) {
//            OutlinedButton(
//                onClick = { isLoginSelected = true },
//                border = if (isLoginSelected) BorderStroke(2.dp, Color(0xFF228B22)) else null,
//                colors = ButtonDefaults.outlinedButtonColors(
//                    containerColor = if (isLoginSelected) Color.White else Color(0xFF228B22),
//                    contentColor = if (isLoginSelected) Color(0xFF228B22) else Color.White
//                ),
//                shape = RoundedCornerShape(8.dp),
//                modifier = Modifier.weight(1f)
//            ) {
//                Text("Log in")
//            }
//            Spacer(modifier = Modifier.width(8.dp))
//            OutlinedButton(
//                onClick = { isLoginSelected = false },
//                border = if (!isLoginSelected) BorderStroke(2.dp, Color(0xFF228B22)) else null,
//                colors = ButtonDefaults.outlinedButtonColors(
//                    containerColor = if (!isLoginSelected) Color.White else Color(0xFF228B22),
//                    contentColor = if (!isLoginSelected) Color(0xFF228B22) else Color.White
//                ),
//                shape = RoundedCornerShape(8.dp),
//                modifier = Modifier.weight(1f)
//            ) {
//                Text("Register")
//            }
//        }
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        // Email TextField
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text("Email address") },
//            modifier = Modifier.fillMaxWidth(),
//            shape = RoundedCornerShape(12.dp),
//            singleLine = true
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Password TextField with visibility toggle
//        OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Password") },
//            modifier = Modifier.fillMaxWidth(),
//            shape = RoundedCornerShape(12.dp),
//            singleLine = true,
//            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
//            trailingIcon = {
//                val icon = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
//                IconButton(onClick = { passwordVisible = !passwordVisible }) {
//                    Icon(icon, contentDescription = if (passwordVisible) "Hide password" else "Show password")
//                }
//            }
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        // Remember me and Forgot password row
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Checkbox(
//                    checked = false,
//                    onCheckedChange = {}
//                )
//                Text(text = "Remember me")
//            }
//            TextButton(onClick = { /* TODO: Forgot password functionality */ }) {
//                Text(text = "Forgot password?")
//            }
//        }
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        // Login or Register Button
//        Button(
//            onClick = { /* TODO: Handle login or register */ },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(48.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF228B22)),
//            shape = RoundedCornerShape(12.dp)
//        ) {
//            Text(
//                text = if (isLoginSelected) "Log in" else "Register",
//                color = Color.White,
//                fontSize = 18.sp
//            )
//        }
//
//        Spacer(modifier = Modifier.height(35.dp))
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceEvenly,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Divider(modifier = Modifier
//                .weight(1f)
//                .height(2.dp))
//            // Or login with social media
//            Text(
//                text = "Or Login with",
//                modifier = Modifier
//                    .padding(8.dp)
//                    .weight(1f),
//                textAlign = TextAlign.Center
//            )
//
//            Divider(modifier = Modifier
//                .weight(1f)
//                .height(2.dp))
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        // Social Media Buttons
//        Row(
//            horizontalArrangement = Arrangement.SpaceEvenly,
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            SocialButton(icon = "Facebook")
//            SocialButton(icon = "Google")
//            SocialButton(icon = "Apple")
//        }
//    }
//}
//
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

//@Preview(showBackground = true)
//@Composable
//fun LoginScreenPreview() {
//    LoginScreen()
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginRegisterScreen(navController: NavController) {
    var isLoginSelected by remember { mutableStateOf(true) }  // Toggle between Login and Register
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue("")) }
    var address by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // App Title
        Text(
            text = "Farmer's Diary",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF228B22),
            modifier = Modifier.padding(vertical = 24.dp)
        )

        // Toggle between Login and Register
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

        Spacer(modifier = Modifier.height(24.dp))

        // Login Form with animation
        AnimatedVisibility(
            visible = isLoginSelected,
            enter = fadeIn(),
            exit = fadeOut()
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
                    onClick = { /* TODO: Handle login or register */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .clickable {
                            navController.navigate(Screens.AppRoute.route)
                        },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF228B22)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = if (isLoginSelected) "Log in" else "Register",
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
                    SocialButton(icon = R.drawable.search)
                    SocialButton(icon = R.drawable.apple)
                }
            }
        }


        // Register Form with animation
        AnimatedVisibility(
            visible = !isLoginSelected,
            enter = fadeIn(),
            exit = fadeOut()
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

@Preview(showBackground = true)
@Composable
fun LoginRegisterScreenPreview() {
    LoginRegisterScreen(rememberNavController())
}




