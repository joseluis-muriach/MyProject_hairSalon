package com.example.myproject_hairsalon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myproject_hairsalon.ui.theme.fontCourgette

@Composable
fun CoverTypeFace() {
    Column(
        Modifier.fillMaxSize(),
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .background(Color(0xFFF6CFFF)),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "What is your face type?",
                fontSize = 30.sp,
                fontFamily = fontCourgette
            )
        }
        Spacer(modifier = Modifier.padding(20.dp))

        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(
                    id = R.drawable.fwtp),
                contentDescription = "Foto con las medidas",
                modifier = Modifier.size(400.dp)
            )
            Row(
                Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "· In the section you can see how to take measurements " +
                            "to see your face type",
                    Modifier.padding(10.dp),
                    fontFamily = fontCourgette
                )
            }
        }
    }
}