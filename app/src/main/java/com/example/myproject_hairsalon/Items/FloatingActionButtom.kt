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
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController

@Composable
fun FloatingButtom(navController: NavController){
    FloatingActionButton(
        onClick = {
            navController.navigate("CoverTypeFace")
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
            text = "See faces types",
            fontFamily = fontCourgette,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}

@Composable
fun FloatingButton(navController: NavHostController, url: String) {
    //Variable en la cual guardaremos la URL del instagram:
    val websiteUrl = "https://instagram.com/andrea.laslo?igshid=OGQ5ZDc2ODk2ZA=="
    val context = LocalContext.current

    //Esta variable es necesaria para hacer un floating con borde de color
    val value by rememberInfiniteTransition(label = "").animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearEasing
            )
        ), label = ""
    )

    val colors = listOf(
        Color(0xFFFEFFFF),
        Color(0xFF080809),
    )
    val gradientBrush by remember { mutableStateOf(
        Brush.horizontalGradient(
            colors = colors,
            startX = -10.0f,
            endX = 400.0f,
            tileMode = TileMode.Repeated
        )
    )
    }
    //Hasta aqui

    FloatingActionButton(
        onClick = {
            openUrlInBrowser(context, websiteUrl)},
        modifier = Modifier
            .padding(16.dp)
            //Esto nos hace falta para poner el borde de color
            .drawBehind {
                rotate(value) {
                    drawCircle(
                        gradientBrush, style = Stroke(width = 12.dp.value)
                    )
                }
            },//Hasta aquí
        containerColor = Color(0xFFF6CFFF),
        //Hacemos el floating redondo
        shape = CircleShape
    ) {
        Icon(
            imageVector = Icons.Default.Create,
            contentDescription = null,
            tint = Color.Black
        )

//        ClickableText(
//            text = { AnnotatedString("Abrir Google") },
//            onClick = { offset ->
//                if (offset < "Abrir Google".length) {
//                    openUrlInBrowser(url)
//                }
//            }
//        )
    }
}


fun openUrlInBrowser(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}