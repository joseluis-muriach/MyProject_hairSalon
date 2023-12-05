package com.example.myproject_hairsalon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myproject_hairsalon.AllMains.MainCalculateMyFace
import com.example.myproject_hairsalon.AllMains.MainCover
import com.example.myproject_hairsalon.AllMains.MainHowCalcFace
import com.example.myproject_hairsalon.AllTypesFaceAndDescrip.AllTypesFaceAndDescrip
import com.example.myproject_hairsalon.Cover.MainCoverVertical
import com.example.myproject_hairsalon.Cover.MainCoverLandScape
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
                    composable("MainCalculateMyFace") { MainCalculateMyFace(navController) }

                    //Type faces and description
                    composable("CoverTypeFace") { AllTypesFaceAndDescrip(navController) }

                    //How calculate your face
                    composable("MainHowCalcFace") { MainHowCalcFace(navController) }
                    composable("VideoHowCalculateMyFace") { MainHowCalcFace(navController) }
                    composable("VideoCalculateTypeFace_LS") { MainHowCalcFace(navController) }

                    //Menú desplazable
                    composable("How calculate my type face") { MainHowCalcFace(navController) }
                    composable("Calculate your type face") { MainCalculateMyFace(navController) }
                    composable("Types faces") { AllTypesFaceAndDescrip(navController) }

                    //Calculate your face (how only if one screen if you want this not necessary)
                    //composable("MainCalculateMyFace") { MainCalculateMyFace(navController) }

                }
            }
        }
    }
}
