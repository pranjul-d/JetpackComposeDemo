package com.softradix.jetpackcomposedemo.harency

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.softradix.jetpackcomposedemo.navigation.navUtils.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(route = Screen.LoginScreen.route) {
        }
        composable(route = Screen.CountryCodeScreen.route) {

        }
    }

}