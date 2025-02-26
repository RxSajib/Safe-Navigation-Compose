package com.news.navigationcompose.ui.navigation

import kotlinx.serialization.Serializable

sealed class NavUtils {

    @Serializable
    data object PageOne : NavUtils()

    @Serializable
    data class PageTwo(val name : String, val age : Int) : NavUtils()

    @Serializable
    data object PageThree : NavUtils()
}