package com.example.feature_show_case

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.feature_show_case.navigation.ShowCaseNavigation
import org.koin.compose.koinInject

@Composable
fun TestNavigationTwo(
    name: String
) {
    val navigation: ShowCaseNavigation = koinInject()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                navigation.popBackStack()
            }
        ) {
            Text(text = "PopBackStack")
        }
        Text(text = "TestNavigationTwo $name")
        Button(
            onClick = {
                navigation.goToNavigateOne()
            }
        ) {
            Text(text = "Navigate")
        }
    }
}