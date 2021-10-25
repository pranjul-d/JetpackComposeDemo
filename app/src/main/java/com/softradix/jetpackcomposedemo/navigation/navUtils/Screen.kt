package com.softradix.jetpackcomposedemo.navigation.navUtils

sealed class Screen(val route:String){
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")
    object LoginScreen : Screen("login_screen")
    object CountryCodeScreen : Screen("countryCode_screen")
}
