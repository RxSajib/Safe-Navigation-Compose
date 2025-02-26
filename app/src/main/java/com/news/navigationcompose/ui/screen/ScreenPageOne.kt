package com.news.navigationcompose.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.news.navigationcompose.ui.model.Course
import com.news.navigationcompose.ui.model.Person

@Composable
fun ScreenOne(
    onclick: (Person) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {}) {
            Text(
                text = "Page One",
                modifier = Modifier.clickable {
                    onclick.invoke(Person(
                        name = "Sajib Roy",
                        age = "25",
                        details = "This is the details",
                        course = Course(
                            nameOfCourse = "CSE",
                            major = "CSE"
                        )
                    ))
                }
            )
        }
    }
}