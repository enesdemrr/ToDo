package com.example.todo.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val lightGray = Color(0xFFFCFCFC)
val mediumGray = Color(0xFF9C9C9C)
val darkGray = Color(0xFF141414)


val LowPriorityColor = Color(0xFF00C980)
val MediumPriorityColor = Color(0xFFFFc114)
val HighPriorityColor = Color(0xFFFF4646)
val NonePriorityColor = Color(0xFFFFFFFF)

val Colors.taskItemTextColor: Color
    @Composable
    get() = if (isLight) DarkGray else LightGray

val Colors.taskItemBackgroundColor: Color
    @Composable
    get() = if (isLight) Color.White else DarkGray

val Colors.topAppBarContentColor: Color
    @Composable
    get() = if (isLight) Color.White else lightGray

val Colors.topAppBarBackgroundContentColor: Color
    @Composable
    get() = if (isLight) Purple500 else Color.Black

val Colors.fabBackgroundContentColor: Color
    @Composable
    get() = if (isLight) Teal200 else Purple700