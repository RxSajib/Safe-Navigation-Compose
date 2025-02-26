package com.news.navigationcompose.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Person(
    val name : String,
    val age : String,
    val details : String,
    val course: Course
) : Parcelable

@Serializable
@Parcelize
data class Course(
    val nameOfCourse : String,
    val major : String
) : Parcelable
