package com.example.devshowcase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.navigation.utils.NavigationCommand
import com.example.navigation.utils.NavigationManager
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainViewModel: ViewModel(), KoinComponent {
    private val navigationManager: NavigationManager by inject()

    fun initNavigation(
        navHostController: NavHostController
    ) {
        viewModelScope.launch {
            navigationManager.commands.collect { command ->
                when (command) {
                    NavigationCommand.NavigateUp -> navHostController.navigateUp()
                    is NavigationCommand.PopStackBack -> if(command.route.isNotBlank()) {
                        navHostController.popBackStack(command.route, false)
                    } else {
                        navHostController.popBackStack()
                    }
                    is NavigationCommand.Navigate -> navHostController.navigate(
                        route = command.destination,
                        navOptions = command.navOptions
                    )
                }
            }
        }
    }
}