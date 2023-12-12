package com.example.myproject_hairsalon.AllMains

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.myproject_hairsalon.CalculateMyFace.CalculateMyFace

/*
In this function we can see the navegation to calculateMyFace
*/
@Composable
fun MainCalculateMyFace(navController: NavController) {
    CalculateMyFace(navController)
}