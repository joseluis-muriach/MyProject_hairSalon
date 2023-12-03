package com.example.myproject_hairsalon.AllMains

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavHostController
import com.example.myproject_hairsalon.Cover.MainCoverLandScape
import com.example.myproject_hairsalon.Cover.MainCoverVertical

@Composable
fun MainCover(navController: NavHostController){
    //With this variable we can controller the orientation of the mobile phone
    val configuration = LocalConfiguration.current

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            MainCoverLandScape(navController)
        }
        else -> {
            MainCoverVertical(navController)
        }
    }
}