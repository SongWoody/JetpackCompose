package com.example.jetpackcompose.compose.screen.main.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.R
import com.example.jetpackcompose.compose.screen.colorchecker.ColorCheckerRoute
import kotlinx.coroutines.flow.collectLatest

fun NavGraphBuilder.firstTabScreen(
    navController: NavHostController
) {
    composable(FirstScreenRoute.route) {
        FirstTabScreen(navController)
    }
}

@Composable
fun FirstTabScreen(
    navController: NavHostController,
    viewModel: TabFirstViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true, block = {
        viewModel.navigateRoute.collectLatest {
            navController.navigate(it)
        }
    })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffeef3fc))
    ) {
        val menuItems = viewModel.menuItems.collectAsState()

        Spacer(modifier = Modifier.height(12.dp))
        Text(text = stringResource(id = R.string.bottom_first), fontSize = 20.sp)
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(content = {
            items(menuItems.value) { item ->
                Button(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    onClick = item.onClickAction
                ) {
                    Text(text = item.title)
                }
            }
        })
    }
}

@Preview
@Composable
fun PreFirstTabScreen() {
    FirstTabScreen(navController = rememberNavController())
}

object FirstScreenRoute {
    const val route = "FirstScreen"
}