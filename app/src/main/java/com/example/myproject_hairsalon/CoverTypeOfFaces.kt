package com.example.myproject_hairsalon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myproject_hairsalon.FaceTitleAndDescription.LazyColumItems
import com.example.myproject_hairsalon.ui.theme.fontCourgette

@Composable
fun CoverTypesOfFaces(){
    Column(
        Modifier.fillMaxSize(),
    ) {
        Row(
            Modifier.fillMaxWidth()
                .padding(top = 20.dp)
                .background(Color(0xFFF6CFFF)),
            horizontalArrangement = Arrangement.Center,

        ) {
            Text(
                text = "TYPE OF FACES",
                fontSize = 30.sp,
                fontFamily = fontCourgette
            )
        }
        LazyColumItems()
    }
}