package com.example.myproject_hairsalon.Items

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
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
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController

/*
In this screen we can see the buttons that used in app
* */
@Composable
fun FloatingButtom(navController: NavController) {
    FloatingActionButton(
        onClick = {
            navController.navigate("CoverTypeFace")
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        containerColor = Color(0xFFF3DFF8)
    ) {
        Text(
            text = "See faces types",
            fontFamily = fontCourgette,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}

@Composable
fun FloatingButton(navController: NavHostController, url: String) {
    //In this variable we save the URL of the instagram account:
    val websiteUrl = "https://instagram.com/andrea.laslo?igshid=OGQ5ZDc2ODk2ZA=="
    val context = LocalContext.current
    //This variable is needed to make a floating button with a colored border.
    val value by rememberInfiniteTransition(label = "").animateFloat(
        initialValue = 20f,
        targetValue = -20f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 600,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val valueRotation by rememberInfiniteTransition(label = "").animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearEasing
            ),
        ), label = ""
    )

    val colors =
        listOf(
            Color(0xFFAB41F8),
            Color(0xFFE91E63),
            Color(0xFFFF5722),
            Color(0xFFFFC107),
        )
    val gradientBrush by remember {
        mutableStateOf(
            Brush.horizontalGradient(
                colors = colors,
                startX = -10.0f,
                endX = 400.0f,
                tileMode = TileMode.Repeated
            )
        )
    }

    FloatingActionButton(
        onClick = {
            openUrlInBrowser(context, websiteUrl)
        },
        modifier = Modifier
            .padding(16.dp)
            //Esto nos hace falta para poner el borde de color
            .drawBehind {
                rotate(valueRotation) {
                    drawCircle(
                        gradientBrush, style = Stroke(width = 20.dp.value)
                    )
                }
            },
        containerColor = Color(0xFFF3DFF8),
        //Make rounded floating
        shape = CircleShape
    ) {
        Icon(
            imageVector = Icons.Default.FavoriteBorder,
            contentDescription = "Icono",
            tint = Color.Black,
            modifier = Modifier
                .size(25.dp)
                .graphicsLayer(
                    transformOrigin =
                    TransformOrigin(
                        pivotFractionX = 0.5f,
                        pivotFractionY = 0.5f
                    ),
                    rotationZ = value)
        )
    }
}

//This function is used to open the url in the browser
fun openUrlInBrowser(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

@Composable
fun FloatingActionRollBack(navController: NavController) {
    FloatingActionButton(
        onClick = {
            navController.navigate("Types faces")
        },
        modifier = Modifier
            .padding(16.dp),
        containerColor = Color(0xFFF3DFF8)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Arrow back",
            tint = Color.Black,
            modifier = Modifier
                .size(25.dp)
        )
    }
}