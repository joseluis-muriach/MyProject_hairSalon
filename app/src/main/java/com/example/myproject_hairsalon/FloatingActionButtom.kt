package com.example.myproject_hairsalon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myproject_hairsalon.ui.theme.fontCourgette

@Composable
fun FloatingButtom(navController: NavController){
    FloatingActionButton(
        onClick = {
            navController.navigate("CoverTypesOfFaces")
            // Handle click action here
            // For example, show a snackbar
            // SnackbarHostState.current.showSnackbar("FAB Clicked")
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        containerColor = Color(0xFFF6CFFF)
    ) {
        Text(
            text = "See the faces types",
            fontFamily = fontCourgette,
            fontSize = 21.sp
        )
    }
}
@Composable
fun FloatingButtomB(){
    FloatingActionButton(
        onClick = {
            //navController.navigate("CoverTypesOfFaces")
            // Handle click action here
            // For example, show a snackbar
            // SnackbarHostState.current.showSnackbar("FAB Clicked")
        },
        modifier = Modifier
            .padding(16.dp),
        containerColor = Color(0xFFF6CFFF)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Color.Black
        )
    }
}