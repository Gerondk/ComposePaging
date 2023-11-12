package com.gkp.composepaging.util

sealed class Screen(val route: String) {
    object ListScreen : Screen("List")
    object DetailScreen: Screen("Detail/{id}") {
        fun navigateArg(argument: String) = "Detail/$argument"
    }
}