package com.example.navigation.routes

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    data object TestNavigationOne : Routes()

    @Serializable
    data class TestNavigationTwo(
        val name: String
    ) : Routes()

    @Serializable
    data object GetAddressScreen : Routes()

}