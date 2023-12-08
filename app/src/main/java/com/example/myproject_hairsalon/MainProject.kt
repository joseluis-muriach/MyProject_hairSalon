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
import com.example.myproject_hairsalon.AllTypesFaceAndDescrip.RealTyoeFaces.LazyRowPhotoL
import com.example.myproject_hairsalon.AllTypesFaceAndDescrip.RealTyoeFaces.LazyRowPhotoR
import com.example.myproject_hairsalon.AllTypesFaceAndDescrip.RealTyoeFaces.LazyRowPhotoC
import com.example.myproject_hairsalon.AllTypesFaceAndDescrip.RealTyoeFaces.LazyRowPhotoRo
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

                    //Scrollable menu
                    composable("How calculate my type face") { MainHowCalcFace(navController) }
                    composable("Calculate your type face") { MainCalculateMyFace(navController) }
                    composable("Types faces") { AllTypesFaceAndDescrip(navController) }

                    //Real type faces
                    composable("LazyRowPhotoL") { LazyRowPhotoL(navController) }
                    composable("LazyRowPhotoR") { LazyRowPhotoR(navController) }
                    composable("LazyRowPhotoRo") { LazyRowPhotoRo(navController) }
                    composable("LazyRowPhotoC") { LazyRowPhotoC(navController) }


                }
            }
        }
    }
}
