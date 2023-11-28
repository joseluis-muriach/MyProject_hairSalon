package com.example.myproject_hairsalon

import VideoHowCalculateMyFace
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myproject_hairsalon.WhatIsYourTypeFace.HowCalculateFace
import com.example.myproject_hairsalon.ui.theme.MyProject_hairSalonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyProject_hairSalonTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "VideoTypesOfFaces") {
                    composable("CoverTypeFace") { CoverTypesOfFaces(navController) }
                    composable("VideoTypesOfFaces") { VideoHowCalculateMyFace(navController) }
                    composable("HowCalculateFace") { HowCalculateFace(navController) }
                }
            }
        }
    }
}
