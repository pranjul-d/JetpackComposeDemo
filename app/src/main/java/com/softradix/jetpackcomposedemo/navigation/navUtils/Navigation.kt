package com.softradix.jetpackcomposedemo.navigation.navUtils

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.softradix.jetpackcomposedemo.navigation.MainScreen
import com.softradix.jetpackcomposedemo.navigation.UserDetail

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController)
        }
        composable(route = "${Screen.DetailScreen.route}}") { entry ->
            val userObject = /*entry.arguments?.getString("user")*/entry.arguments?.getParcelable<UserDetail>("user")

//            val data =  Gson().fromJson(entry.arguments?.getString("user"), UserDetail::class.java)
            Toast.makeText(context, userObject.toString(), Toast.LENGTH_SHORT).show()
//            DetailsScreen(userObject)
        }
    }

}