package com.news.navigationcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.news.navigationcompose.ui.screen.PageThree
import com.news.navigationcompose.ui.screen.PageTwo
import com.news.navigationcompose.ui.screen.ScreenOne

@Composable
fun NavGrap(modifier: Modifier = Modifier) {

    val navcontroller = rememberNavController()
    NavHost(navController = navcontroller, startDestination = NavUtils.PageOne){
        composable<NavUtils.PageOne> {
            ScreenOne(
                onclick = {
                    navcontroller.navigate(NavUtils.PageTwo(
                        name = "Sajib Roy",
                        age = 25
                    ))
                }
            )
        }

        composable<NavUtils.PageTwo> {
            val args = it.toRoute<NavUtils.PageTwo>()
            PageTwo(args.name, args.age)
        }

        composable<NavUtils.PageThree> {
            PageThree()
        }
    }
    
}