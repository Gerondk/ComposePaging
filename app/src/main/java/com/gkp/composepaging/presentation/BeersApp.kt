package com.gkp.composepaging.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gkp.composepaging.util.BEER_ID
import com.gkp.composepaging.util.Screen

@Composable
fun BeersApp() {

   val navController = rememberNavController()
   NavHost(
       navController = navController,
       startDestination = Screen.ListScreen.route
   ) {
       composable(Screen.ListScreen.route) {
           BeersListScreen(
               onNavigateToDetail = {
                   navController.navigate(Screen.DetailScreen.navigateArg(it))
               }
           )
       }
       composable(
           Screen.DetailScreen.route,
           arguments = listOf(navArgument(name = BEER_ID) { type = NavType.IntType })
       ) {
           BeerDetailScreen()
       }
   }

}