package com.example.bookquiz.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookquiz.compose.home.HomeScreen

@Composable
fun BookQuizApp(){
    val navController = rememberNavController()
    BookQuizNavHost(
        navController = navController
    )
}

@Composable
fun BookQuizNavHost(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route){
            HomeScreen()
        }
    }
}