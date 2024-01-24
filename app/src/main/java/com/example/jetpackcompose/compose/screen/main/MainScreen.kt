package com.example.jetpackcompose.compose.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.compose.screen.main.tab.BottomNavItem
import com.example.jetpackcompose.compose.screen.main.tab.FirstScreenRoute
import com.example.jetpackcompose.compose.screen.main.tab.firstTabScreen
import com.example.jetpackcompose.compose.screen.main.tab.secondTabScreen
import com.example.jetpackcompose.compose.screen.main.tab.thirdTabScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController
) {
    val bottomNavController = rememberNavController()


    Scaffold(
        bottomBar = {
            MyBottomBav(bottomNavController = bottomNavController)
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            NavHost(
                navController = bottomNavController,
                startDestination = FirstScreenRoute.route
            ) {
                firstTabScreen(navController)
                secondTabScreen()
                thirdTabScreen()
            }
        }
    }
}

@Composable
fun MyBottomBav(
    bottomNavController: NavController
) {
    val tabList = listOf(BottomNavItem.First, BottomNavItem.Second, BottomNavItem.Third)
    var navigationSelectedItem by remember {
        mutableStateOf(0)
    }
    androidx.compose.material3.NavigationBar {
        tabList.forEachIndexed { index, bottomNavItem ->
            NavigationBarItem(
                selected = (index == navigationSelectedItem),
                onClick = {
                    navigationSelectedItem = index
                    bottomNavController.navigate(bottomNavItem.screenRoute) {
                        popUpTo(bottomNavController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(painter = painterResource(id = bottomNavItem.icon), contentDescription = "") }
            )
        }
    }
}