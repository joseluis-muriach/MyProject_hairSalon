package com.example.myproject_hairsalon.Cover

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myproject_hairsalon.Items.FloatingButton
import com.example.myproject_hairsalon.R
import com.example.myproject_hairsalon.ui.theme.fontCourgette

@Composable
fun MainCoverVertical(navController: NavHostController) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(60.dp))

        Image(
            painter = painterResource(id = R.drawable.logoandrea),
            contentDescription = "app picture",
            modifier = Modifier
                .size(220.dp)
                .border(1.dp, Color.Black, CircleShape)
                .clip(shape = RoundedCornerShape(40.dp))
        )

        Spacer(modifier = Modifier.padding(40.dp))

        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 35.dp, end = 35.dp, bottom = 7.dp)
                    .background(color = Color(0xFFF6CFFF), RoundedCornerShape(50.dp))
                    .border(
                        1.dp,
                        Color.Black,//2.dp es el grosor del borde y Color.Black es el color del borde
                        RoundedCornerShape(50.dp)
                    ),//colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF6CFFF)),
                verticalAlignment = CenterVertically,

                ) {
                Button(
                    onClick = { navController.navigate("VideoHowCalculateMyFace") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(CenterVertically)

                ) {
                    Text(
                        text = "How calculate you face",
                        color = Color.Black,
                        fontFamily = fontCourgette,
                        fontSize = 20.sp
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 35.dp, end = 35.dp, bottom = 7.dp)
                    .background(color = Color(0xFFF6CFFF), RoundedCornerShape(50.dp))
                    .border(1.dp, Color.Black,
                        RoundedCornerShape(50.dp)),
                verticalAlignment = CenterVertically
            ) {
                Button(
                    onClick = { navController.navigate("MainCalculateMyFace") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF6CFFF)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(CenterVertically)
                ) {
                    Text(
                        text = "Calculate my face type",
                        color = Color.Black,
                        fontFamily = fontCourgette,
                        fontSize = 20.sp
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 35.dp, end = 35.dp, bottom = 7.dp)
                    .background(color = Color(0xFFF6CFFF), RoundedCornerShape(50.dp))
                    .border(
                        1.dp,
                        Color.Black,//2.dp es el grosor del borde y Color.Black es el color del borde
                        RoundedCornerShape(50.dp)
                    ),//colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF6CFFF)),
                verticalAlignment = CenterVertically,

                ) {
                Button(
                    onClick = { navController.navigate("CoverTypeFace") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF6CFFF)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(CenterVertically)

                ) {
                    Text(
                        text = "All face types",
                        color = Color.Black,
                        fontFamily = fontCourgette,
                        fontSize = 20.sp
                    )
                }
            }

            Box(
                Modifier
                    .padding(top = 16.dp)
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomEnd
            ) {
                FloatingButton(
                    navController, "https://instagram.com/andrea.laslo?igshid=OGQ5ZDc2ODk2ZA=="
                )
            }
        }
    }
}