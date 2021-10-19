package com.softradix.jetpackcomposedemo.navigation

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson
import com.softradix.jetpackcomposedemo.navigation.navUtils.Screen
import com.squareup.moshi.Moshi

@Composable
fun MainScreen(navController: NavController) {
    var context = LocalContext.current
    var textState by remember { mutableStateOf("Pranjul") }
    var age by remember { mutableStateOf("20") }
    Column(modifier = Modifier.fillMaxSize()) {


        TextField(
            value = textState, onValueChange = {
                textState = it
            }, modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = age, onValueChange = {
                age = it
            }, modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(10.dp)
                .align(alignment = Alignment.End)
        )

        Button(onClick = {
            val user = UserDetail(textState, age)


            try {
                val jsonString = Gson().toJson(user)
                val moshi = Moshi.Builder().build()
                val jsonAdapter = moshi
                    .adapter(UserDetail::class.java)
                    .lenient()
                val userJson = jsonAdapter.toJson(user)

                navController.currentBackStackEntry?.
                savedStateHandle?.set("user", user)
                navController
                    .navigate(Screen.DetailScreen.route)
//                            "/$jsonString")
            } catch (e: Exception) {
                Log.e("ExceptionData", e.toString())
            }


        }) {
            Text("Send Data")
        }
    }


}