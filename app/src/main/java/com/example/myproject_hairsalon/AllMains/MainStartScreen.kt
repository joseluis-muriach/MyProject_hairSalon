import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myproject_hairsalon.R
import com.example.myproject_hairsalon.ui.theme.fontCourgette
import kotlinx.coroutines.delay

@Composable
fun MainStartScreen(navController: NavController) {
    val textWithName = "Created by:\nJose Luis Muriach Martin"

    // Utilizamos animateFloatAsState para obtener el valor animado como un estado
    val value by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(
            durationMillis = 2000,
            easing = LinearEasing
        ), label = ""
    )

    Box {
        //Aplicamos la animación al Modifier para controlar la posición vertical de la imagen
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    scaleX = value
                    scaleY = value
                },
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logoandrea2),
                contentDescription = "el logo que tenemos en la portada"
            )
        }

        Text(
            text = textWithName,
            fontSize = 15.sp,
            fontFamily = fontCourgette,
            modifier = Modifier
                .align(BottomCenter)
                .padding(10.dp),
            textAlign = TextAlign.Center
        )
    }

    // Utilizamos LaunchedEffect para iniciar un temporizador y cambiar a la siguiente pantalla.
    LaunchedEffect(true) {
        delay(2000)
        navController.navigate("MainCover")
    }
}
