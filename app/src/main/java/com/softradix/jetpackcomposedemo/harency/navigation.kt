package com.softradix.jetpackcomposedemo.harency

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.softradix.jetpackcomposedemo.data.CountriesItem
import com.softradix.jetpackcomposedemo.navigation.DetailsScreen
import com.softradix.jetpackcomposedemo.navigation.UserDetail
import com.softradix.jetpackcomposedemo.navigation.navUtils.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(route = Screen.LoginScreen.route+"/{user}", arguments = listOf(
            navArgument("data") { type = NavType.StringType }
        )) { navEntry ->
            HarencyLoginScreen(navController = navController)
//            entry.savedStateHandle.get<UserDetail>("user").let { HarencyLoginScreen(it) }
            navEntry.arguments?.getParcelable<CountriesItem>("data")

        }
        composable(route = Screen.CountryCodeScreen.route) {
            CountryCodeScreen(navController)
        }
    }

}