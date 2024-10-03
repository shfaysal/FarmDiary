package com.example.farmdiary.farmDiary.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostScreen(navController: NavController){

    var text by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }


    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 10.dp, end = 10.dp),
        horizontalAlignment = Alignment.Start
    ) {

        Box (
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Post",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.End)
                        .size(30.dp),
                    tint = Color.Black // You can change the color if needed
                )
            }
        }

        Text(
            text = "Title",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(10.dp)), // Light background with rounded corners
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            var fromDate by remember { mutableStateOf("") }
            var toDate by remember { mutableStateOf("") }

            // From Date TextField
            OutlinedTextField(
                value = fromDate,
                onValueChange = { fromDate = it },
                placeholder = { Text("From Date") },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedLabelColor = Color.Gray
                )
            )

        }
        Spacer(modifier = Modifier.height(8.dp))

//        Row (
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//        ) {
//
//            Column (
//                modifier = Modifier.weight(1f),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.Center
//            ) {
//                Text(
//                    textAlign = TextAlign.Start,
//                    text = "Title",
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold
//                )
//
//                OutlinedTextField(
//                    value = text,
//                    onValueChange = {text = it},
//                    label = {Text(text = if (!isFocused) "Enter Title" else "")},
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .onFocusChanged { focusState ->
//                            isFocused = focusState.isFocused
//                        },
//                    shape = RoundedCornerShape(10.dp),
//                    singleLine = true,
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        focusedTextColor = Color.Black,
//                        unfocusedLabelColor = Color.Gray
//                    ),
//                )
//            }
//
//            Spacer(modifier = Modifier.width(5.dp))
//
//            Column (
//                modifier = Modifier.weight(1f)
//            ) {
//                Text(
//                    text = "Title",
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold
//                )
//
//                OutlinedTextField(
//                    value = text,
//                    onValueChange = {text = it},
//                    label = {Text(text = if (!isFocused) "Enter Title" else "")},
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .onFocusChanged { focusState ->
//                            isFocused = focusState.isFocused
//                        },
//                    shape = RoundedCornerShape(10.dp),
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        focusedTextColor = Color.Black,
//                        unfocusedLabelColor = Color.Gray
//                    ),
//                    singleLine = true,
//                )
//            }
//        }
        CateAndSubCateUI()

        Spacer(modifier = Modifier.height(8.dp))
        OfferValidityUI()
        Spacer(modifier = Modifier.height(8.dp))
        DeliveryAndPaymentUI()
        Spacer(modifier = Modifier.height(8.dp))
        LocationAndPriceUI()
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Description",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(10.dp)), // Light background with rounded corners
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            var fromDate by remember { mutableStateOf("") }
            var toDate by remember { mutableStateOf("") }

            // From Date TextField
            OutlinedTextField(
                value = fromDate,
                onValueChange = { fromDate = it },
                placeholder = { Text("Write the description here") },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedLabelColor = Color.Gray
                )
            )

        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()  // Adjust height as needed
                .clickable { /* Handle upload action here */ },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center  // Center the content horizontally
        ) {
            Icon(
                imageVector = Icons.Outlined.CameraAlt,  // Replace with your icon
                contentDescription = "Upload",
                modifier = Modifier.size(24.dp)  // Adjust size of the icon
            )
//            Spacer(modifier = Modifier.width(8.dp))  // Space between icon and text
            Text(
                text = "Upload images/video",
                fontWeight = FontWeight.Bold
                )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){

            Box (
                modifier = Modifier
                    .size(250.dp, 58.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(Color(0xFFFF5C00)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Post",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferValidityUI() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Offer Validity label
        Text(
            text = "Offer Validity",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Row for the From Date and To Date fields
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(10.dp)), // Light background with rounded corners
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            var fromDate by remember { mutableStateOf("") }
            var toDate by remember { mutableStateOf("") }

            // From Date TextField
            OutlinedTextField(
                value = fromDate,
                onValueChange = { fromDate = it },
                placeholder = { Text("From Date") },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                trailingIcon = {
                    Icon(Icons.Outlined.KeyboardArrowDown, contentDescription = "Dropdown")
                },
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedLabelColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            // To Date TextField
            OutlinedTextField(
                value = toDate,
                onValueChange = { toDate = it },
                placeholder = { Text("To Date") },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                trailingIcon = {
                    Icon(Icons.Outlined.KeyboardArrowDown, contentDescription = "Dropdown")
                },
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedLabelColor = Color.Gray
                )
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeliveryAndPaymentUI() {

    Row (
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            // Offer Validity label
            Text(
                text = "Delivery Date",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Row for the From Date and To Date fields
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(10.dp)), // Light background with rounded corners
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                var fromDate by remember { mutableStateOf("") }
                var toDate by remember { mutableStateOf("") }

                // From Date TextField
                OutlinedTextField(
                    value = fromDate,
                    onValueChange = { fromDate = it },
                    placeholder = { Text("09/02/19") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp),
                    trailingIcon = {
                        Icon(Icons.Outlined.CalendarMonth, contentDescription = "Dropdown")
                    },
                    shape = RoundedCornerShape(10.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        focusedLabelColor = Color.Gray
                    )
                )

                Spacer(modifier = Modifier.width(8.dp))

//            // To Date TextField
//            OutlinedTextField(
//                value = toDate,
//                onValueChange = { toDate = it },
//                placeholder = { Text("To Date") },
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(end = 8.dp),
//                trailingIcon = {
//                    Icon(Icons.Outlined.KeyboardArrowDown, contentDescription = "Dropdown")
//                },
//                shape = RoundedCornerShape(10.dp),
//                singleLine = true,
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = Color.Transparent,
//                    unfocusedBorderColor = Color.Transparent,
//                    focusedLabelColor = Color.Gray
//                )
//            )
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            // Offer Validity label
            Text(
                text = "Payment Method",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Row for the From Date and To Date fields
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(10.dp)), // Light background with rounded corners
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                var fromDate by remember { mutableStateOf("") }
                var toDate by remember { mutableStateOf("") }

                // From Date TextField
                OutlinedTextField(
                    value = fromDate,
                    onValueChange = { fromDate = it },
                    placeholder = { Text("Cash") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp),
                    trailingIcon = {
                        Icon(
                            Icons.Outlined.KeyboardArrowDown,
                            contentDescription = "Dropdown")
                    },
                    shape = RoundedCornerShape(10.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        focusedLabelColor = Color.Gray
                    )
                )

                Spacer(modifier = Modifier.width(8.dp))

//            // To Date TextField
//            OutlinedTextField(
//                value = toDate,
//                onValueChange = { toDate = it },
//                placeholder = { Text("To Date") },
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(end = 8.dp),
//                trailingIcon = {
//                    Icon(Icons.Outlined.KeyboardArrowDown, contentDescription = "Dropdown")
//                },
//                shape = RoundedCornerShape(10.dp),
//                singleLine = true,
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = Color.Transparent,
//                    unfocusedBorderColor = Color.Transparent,
//                    focusedLabelColor = Color.Gray
//                )
//            )
            }
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationAndPriceUI() {

    Row (
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            // Offer Validity label
            Text(
                text = "Location",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Row for the From Date and To Date fields
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(10.dp)), // Light background with rounded corners
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                var fromDate by remember { mutableStateOf("") }
                var toDate by remember { mutableStateOf("") }

                // From Date TextField
                OutlinedTextField(
                    value = fromDate,
                    onValueChange = { fromDate = it },
                    placeholder = { Text("Search Locaiton") },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(start = 2.dp),
                    leadingIcon = {
                        Icon(Icons.Outlined.LocationOn, contentDescription = "Dropdown")
                    },
                    shape = RoundedCornerShape(10.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        focusedLabelColor = Color.Gray
                    )
                )

                Spacer(modifier = Modifier.width(8.dp))

//            // To Date TextField
//            OutlinedTextField(
//                value = toDate,
//                onValueChange = { toDate = it },
//                placeholder = { Text("To Date") },
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(end = 8.dp),
//                trailingIcon = {
//                    Icon(Icons.Outlined.KeyboardArrowDown, contentDescription = "Dropdown")
//                },
//                shape = RoundedCornerShape(10.dp),
//                singleLine = true,
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = Color.Transparent,
//                    unfocusedBorderColor = Color.Transparent,
//                    focusedLabelColor = Color.Gray
//                )
//            )
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            // Offer Validity label
            Text(
                text = "Price",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Row for the From Date and To Date fields
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(10.dp)), // Light background with rounded corners
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                var fromDate by remember { mutableStateOf("") }
                var toDate by remember { mutableStateOf("") }

                // From Date TextField
                OutlinedTextField(
                    value = fromDate,
                    onValueChange = { fromDate = it },
                    placeholder = { Text("Enter Price") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp),
                    shape = RoundedCornerShape(10.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        focusedLabelColor = Color.Gray
                    )
                )

                Spacer(modifier = Modifier.width(8.dp))

//            // To Date TextField
//            OutlinedTextField(
//                value = toDate,
//                onValueChange = { toDate = it },
//                placeholder = { Text("To Date") },
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(end = 8.dp),
//                trailingIcon = {
//                    Icon(Icons.Outlined.KeyboardArrowDown, contentDescription = "Dropdown")
//                },
//                shape = RoundedCornerShape(10.dp),
//                singleLine = true,
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = Color.Transparent,
//                    unfocusedBorderColor = Color.Transparent,
//                    focusedLabelColor = Color.Gray
//                )
//            )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CateAndSubCateUI() {

    Row (
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            // Offer Validity label
            Text(
                text = "Categories",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Row for the From Date and To Date fields
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(10.dp)), // Light background with rounded corners
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                var fromDate by remember { mutableStateOf("") }
                var toDate by remember { mutableStateOf("") }

                // From Date TextField
                OutlinedTextField(
                    value = fromDate,
                    onValueChange = { fromDate = it },
                    placeholder = { Text("Select Brand") },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(start = 2.dp),
                    shape = RoundedCornerShape(10.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        focusedLabelColor = Color.Gray
                    )
                )

                Spacer(modifier = Modifier.width(8.dp))

//            // To Date TextField
//            OutlinedTextField(
//                value = toDate,
//                onValueChange = { toDate = it },
//                placeholder = { Text("To Date") },
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(end = 8.dp),
//                trailingIcon = {
//                    Icon(Icons.Outlined.KeyboardArrowDown, contentDescription = "Dropdown")
//                },
//                shape = RoundedCornerShape(10.dp),
//                singleLine = true,
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = Color.Transparent,
//                    unfocusedBorderColor = Color.Transparent,
//                    focusedLabelColor = Color.Gray
//                )
//            )
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            // Offer Validity label
            Text(
                text = "Sub-Categories",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Row for the From Date and To Date fields
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(10.dp)), // Light background with rounded corners
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                var fromDate by remember { mutableStateOf("") }
                var toDate by remember { mutableStateOf("") }

                // From Date TextField
                OutlinedTextField(
                    value = fromDate,
                    onValueChange = { fromDate = it },
                    placeholder = { Text("Sub Categories") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp),
                    shape = RoundedCornerShape(10.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        focusedLabelColor = Color.Gray
                    )
                )

                Spacer(modifier = Modifier.width(8.dp))

//            // To Date TextField
//            OutlinedTextField(
//                value = toDate,
//                onValueChange = { toDate = it },
//                placeholder = { Text("To Date") },
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(end = 8.dp),
//                trailingIcon = {
//                    Icon(Icons.Outlined.KeyboardArrowDown, contentDescription = "Dropdown")
//                },
//                shape = RoundedCornerShape(10.dp),
//                singleLine = true,
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = Color.Transparent,
//                    unfocusedBorderColor = Color.Transparent,
//                    focusedLabelColor = Color.Gray
//                )
//            )
            }
        }
    }

}

@Preview (showBackground = true)
@Composable
fun PostScreenPreview(){
    val navController = rememberNavController()
    PostScreen(navController)
}