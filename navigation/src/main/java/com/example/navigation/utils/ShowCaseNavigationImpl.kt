package com.example.navigation.utils

import com.example.feature_show_case.navigation.ShowCaseNavigation
import com.example.navigation.routes.Routes

class ShowCaseNavigationImpl(
    private val navigationManager: NavigationManager
): ShowCaseNavigation {

    override fun goToNavigateOne() {
        navigationManager.navigate(Routes.TestNavigationOne)
    }

    override fun goToNavigateTwo() {
        navigationManager.navigate(Routes.TestNavigationTwo("Marcelo"))
    }

    override fun popBackStack() {
       navigationManager.popStackBack()
    }
}