package com.example.di.modules


import com.example.feature_show_case.navigation.ShowCaseNavigation
import com.example.navigation.utils.NavigationManager
import com.example.navigation.utils.ShowCaseNavigationImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module

val navigationModule = module {
    single {
        NavigationManager(
            CoroutineScope(
                SupervisorJob() + Dispatchers.Main
            )
        )
    }

    single<ShowCaseNavigation> {
        ShowCaseNavigationImpl(get())
    }
}