package com.news.navigationcompose.ui.navigation

import android.os.Build
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.news.navigationcompose.ui.model.Person
import com.news.navigationcompose.ui.screen.PageThree
import com.news.navigationcompose.ui.screen.PageTwo
import com.news.navigationcompose.ui.screen.ScreenOne
import kotlinx.serialization.json.Json
import kotlin.reflect.typeOf


val PersonType = object : NavType<Person>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Person? {
        return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            bundle.getParcelable(key, Person::class.java)
        }else {
            bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): Person {
        return Json.decodeFromString(value)
    }

    override fun put(bundle: Bundle, key: String, value: Person) {
        bundle.putParcelable(key, value)
    }

    override fun serializeAsValue(value: Person): String {
        return Json.encodeToString(value)
    }

}

@Composable
fun NavGrap(modifier: Modifier = Modifier) {

    val navcontroller = rememberNavController()
    NavHost(navController = navcontroller, startDestination = NavUtils.PageOne){
        composable<NavUtils.PageOne> {
            ScreenOne(
                onclick = {
                    navcontroller.navigate(NavUtils.PageTwo(
                      Person(
                          name = "Sajib",
                          age = "20",
                          details = "This is details"
                      )
                    ))
                }
            )
        }

        composable<NavUtils.PageTwo>(
            typeMap = mapOf(typeOf<Person>() to PersonType)
        ) {
            val args = it.toRoute<NavUtils.PageTwo>()
            PageTwo(args.person.name, args.person.age)
        }

        composable<NavUtils.PageThree> {
            PageThree()
        }
    }
    
}