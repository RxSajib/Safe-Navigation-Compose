package com.news.navigationcompose.ui.navigation

import com.news.navigationcompose.ui.model.Person
import kotlinx.serialization.Serializable

sealed class NavUtils {

    @Serializable
    data object PageOne : NavUtils()

    @Serializable
    data class PageTwo(val person : Person) : NavUtils()

    @Serializable
    data object PageThree : NavUtils()
}