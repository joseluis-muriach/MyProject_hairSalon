package com.example.myproject_hairsalon.AllTypesFaceAndDescrip

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myproject_hairsalon.AllTypesFaceAndDescrip.FaceTitleAndDescription.LazyColumItems
import com.example.myproject_hairsalon.Items.MyTopAppBarC
import com.example.myproject_hairsalon.ui.theme.fontCourgette

/*
This class is the screen of "Type faces" where we can see the design.
*/
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllTypesFaceAndDescrip(navController: NavController) {
    Scaffold(
        topBar = { MyTopAppBarC(navController) }
    ) {
        Column(
            Modifier.fillMaxSize(),
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .background(Color(0xFFF3DFF8)),
                horizontalArrangement = Arrangement.Center,

                ) {
                Text(
                    text = "TYPE OF FACES",
                    fontSize = 30.sp,
                    fontFamily = fontCourgette
                )
            }
            LazyColumItems(navController)
        }
    }
}
