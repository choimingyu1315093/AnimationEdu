package com.example.navigationedu.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.navigationedu.navigation.BookScreens

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = {
                navController.navigate(BookScreens.DETAILSCREEN.name+"/어린왕자")
            }
        ) {
            Text(
                text = "DetailScreen 이동"
            )
        }
    }
}