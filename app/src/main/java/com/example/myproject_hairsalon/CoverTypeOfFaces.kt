package com.example.myproject_hairsalon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myproject_hairsalon.TypeOfFaces.LazyColumItems
import com.example.myproject_hairsalon.ui.theme.fontCourgette

@Composable
fun CoverTypesOfFaces(){
    Column(
        Modifier.fillMaxSize(),
    ) {
        Row(
            Modifier.fillMaxWidth()
                .padding(top = 15.dp)
                .background(Color(0xFFFDF1D1)),
            horizontalArrangement = Arrangement.Center,

        ) {
            Text(
                text = "TYPE OF FACES",
                fontSize = 20.sp,
                fontFamily = fontCourgette
            )
        }
        LazyColumItems()
    }
}