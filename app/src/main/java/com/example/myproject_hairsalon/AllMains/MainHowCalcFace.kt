package com.example.myproject_hairsalon.AllMains

import VideoHowCalculateMyFace
import com.example.myproject_hairsalon.WhatIsYourTypeFace.VideoCalculateTypeFace.VideoCalculateTypeFace_LS
import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavHostController

/*
In this Screen also we can see two form, the navegability to VideoCalculate in vertical form or horizontal form
*/
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