package com.example.myproject_hairsalon.MainCover

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun MainCoverLandScape(navController: NavHostController) {
    Column {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.logoandrea),
                    alignment = Alignment.Center,
                    contentDescription = "app picture",
                    modifier = Modifier
                        .padding(top = 26.dp)
                        .size(220.dp)
                        .border(1.dp, Color.Black, CircleShape)
                        .clip(shape = RoundedCornerShape(40.dp))
                )
            }

            item {
                Spacer(modifier = Modifier.padding(20.dp))
            }

            item {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 105.dp, end = 105.dp, bottom = 7.dp)
                            .background(color = Color(0xFFF6CFFF), RoundedCornerShape(50.dp))
                            .border(
                                1.dp,
                                Color.Black,//2.dp es el grosor del borde y Color.Black es el color del borde
                                RoundedCornerShape(50.dp)
                            ),//colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF6CFFF)),
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Button(
                            onClick = { navController.navigate("VideoCalculateTypeFace_LS") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterVertically)

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
                            .padding(
                                start = 105.dp, end = 105.dp, bottom = 7.dp)
                            .background(color = Color(0xFFF6CFFF), RoundedCornerShape(50.dp))
                            .border(
                                1.dp, Color.Black,
                                RoundedCornerShape(50.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = { navController.navigate("MainCalculateMyFace") },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF6CFFF)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterVertically)
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
                            .padding(
                                start = 105.dp, end = 105.dp, bottom = 7.dp)
                            .background(color = Color(0xFFF6CFFF), RoundedCornerShape(50.dp))
                            .border(
                                1.dp,
                                Color.Black,//2.dp es el grosor del borde y Color.Black es el color del borde
                                RoundedCornerShape(50.dp)
                            ),//colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF6CFFF)),
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Button(
                            onClick = { navController.navigate("CoverTypeFace") },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF6CFFF)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterVertically)

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
                            navController,
                            "https://instagram.com/andrea.laslo?igshid=OGQ5ZDc2ODk2ZA=="
                        )
                    }
                }
            }
        }
    }
}