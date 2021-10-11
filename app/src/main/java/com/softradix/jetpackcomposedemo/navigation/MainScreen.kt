package com.softradix.jetpackcomposedemo.navigation

import android.util.Log
import android.widget.Toast
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
import com.softradix.jetpackcomposedemo.navigation.navUtils.Screen

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
            Toast.makeText(context, user.toString(), Toast.LENGTH_SHORT).show()


            try {
                navController.currentBackStackEntry?.arguments?.putParcelable("user", user)
                navController
                    .navigate(Screen.DetailScreen.route)
            }catch (e:Exception){
                Log.e("ExceptionData",e.localizedMessage)
            }


        }) {
            Text("Send Data")
        }
    }


}