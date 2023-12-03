package com.example.myproject_hairsalon

import VideoHowCalculateMyFace
import com.example.myproject_hairsalon.WhatIsYourTypeFace.VideoCalculateTypeFace.VideoCalculateTypeFace_LS
import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavHostController
import com.example.myproject_hairsalon.MainCover.MainCoverLandScape
import com.example.myproject_hairsalon.MainCover.MainCoverVertical

@Composable
fun MainHowCalcFace(navController: NavHostController){
    //With this variable we can controller the orientation of the mobile phone
    val configuration = LocalConfiguration.current

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            VideoCalculateTypeFace_LS(navController)
        }
        else -> {
            VideoHowCalculateMyFace(navController)
        }
    }
}