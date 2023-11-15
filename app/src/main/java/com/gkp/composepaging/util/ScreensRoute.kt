package com.gkp.composepaging.util

sealed class Screen(val route: String) {
    object ListScreen : Screen("List")
    object DetailScreen: Screen("Detail/{$BEER_ID}") {
        fun navigateArg(argument: Int) = "Detail/$argument"
    }
}