package com.example.myproject_hairsalon

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.myproject_hairsalon.MainCover.MainCoverLandScape
import com.example.myproject_hairsalon.MainCover.MainCoverVertical

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