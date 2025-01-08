package com.example.navigation.hosts

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.feature_show_case.TestNavigationOne
import com.example.feature_show_case.TestNavigationTwo
import com.example.navigation.routes.Routes

@Composable
fun Host(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        startDestination = Routes.TestNavigationOne
    ) {
        composable<Routes.TestNavigationOne> {
            TestNavigationOne()
        }
        composable<Routes.TestNavigationTwo> { backStackEntry ->
            val test: Routes.TestNavigationTwo = backStackEntry.toRoute()
            TestNavigationTwo(
                name = test.name
            )
        }
    }
}