package com.example.feature_show_case

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.feature_show_case.navigation.ShowCaseNavigation
import org.koin.compose.koinInject

@Composable
fun TestNavigationOne(

) {
    val navigation: ShowCaseNavigation = koinInject()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "TestNavigationOne")
        Button(
            onClick = {
                navigation.goToNavigateTwo()
            }
        ) {
            Text(text = "Navigate")
        }
    }
}