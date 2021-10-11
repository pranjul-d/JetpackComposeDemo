package com.softradix.jetpackcomposedemo.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun DetailsScreen(data: UserDetail?){

    Column(modifier = Modifier.fillMaxSize().background(color = Color.White)) {
        data?.name?.let { Text(it) }
        data?.age?.let { Text(it) }
    }

}