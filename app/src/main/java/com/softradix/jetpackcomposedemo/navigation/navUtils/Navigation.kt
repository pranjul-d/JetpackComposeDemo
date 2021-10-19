package com.softradix.jetpackcomposedemo.navigation.navUtils

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.softradix.jetpackcomposedemo.navigation.DetailsScreen
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
        composable(route = "${Screen.DetailScreen.route}/{user}", arguments = listOf(
            navArgument("user") {
                type = NavType.StringType
            }
        )) { entry ->
            Log.e("TAG", "Navigation: ${entry.arguments}")
            entry.savedStateHandle.get<UserDetail>("user").let { DetailsScreen(it) }

//            entry.arguments?.getString("user").let {
//                val userObject = Gson().fromJson(it, UserDetail::class.java)
////                Toast.makeText(context, userObject.toString(), Toast.LENGTH_SHORT).show()
//                DetailsScreen(userObject)
//            }

//                entry.arguments?.get<UserDetail>("user")

//            val data =  Gson().fromJson(entry.arguments?.getString("user"), UserDetail::class.java)
        }
    }

}