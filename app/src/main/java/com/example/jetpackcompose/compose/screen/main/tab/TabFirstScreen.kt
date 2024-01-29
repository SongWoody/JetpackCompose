package com.example.jetpackcompose.compose.screen.main.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.R
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
        Text(modifier = Modifier.padding(horizontal = 12.dp),text = stringResource(id = R.string.bottom_checker_title), fontSize = 20.sp)
        Spacer(modifier = Modifier.height(12.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(98.dp)
                .padding(horizontal = 12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                (0..3).forEach {
                    val item = menuItems.value.getOrNull(it)
                    if (item != null) {
                        Box(modifier = Modifier.weight(1f)) {
                            MenuItem(
                                title = item.title,
                                logoId = item.logo,
                                onClick = item.onClickAction
                            )
                        }
                    } else {
                        Box(modifier = Modifier.weight(1f))
                    }
                }
            }

        }
    }
}

@Composable
fun MenuItem(title: String, logoId: Int, onClick: ()->Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick, interactionSource = interactionSource, indication = null),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .weight(1f),
            painter = painterResource(id = logoId),
            contentDescription = title,
            tint = if (isPressed) Color.Gray else LocalContentColor.current
        )
        Text(
            text = title,
            color = if (isPressed) Color.Gray else LocalContentColor.current,
            fontWeight = if (isPressed) FontWeight.Bold else FontWeight.Medium
        )
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