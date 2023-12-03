package com.example.myproject_hairsalon

import VideoHowCalculateMyFace
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myproject_hairsalon.MainCover.MainCoverVertical
import com.example.myproject_hairsalon.MainCover.MainCoverLandScape
import com.example.myproject_hairsalon.WhatIsYourTypeFace.HowCalculateFace
import com.example.myproject_hairsalon.ui.theme.MyProject_hairSalonTheme

class MainProject : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyProject_hairSalonTheme {
                //We need this variable by create the navigation
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "MainCover") {
                    //Main Cover
                    composable("MainCover") { MainCover(navController) }
                    composable("MainCoverVertical") { MainCoverVertical(navController) }
                    composable("MainCoverLandScape") { MainCoverLandScape(navController) }
                    //End Main Cover

                    composable("CoverTypeFace") { CoverTypesOfFaces(navController) }
                    composable("VideoTypesOfFaces") { VideoHowCalculateMyFace(navController) }
                    composable("HowCalculateFace") { HowCalculateFace(navController) }
                }
            }
        }
    }
}
