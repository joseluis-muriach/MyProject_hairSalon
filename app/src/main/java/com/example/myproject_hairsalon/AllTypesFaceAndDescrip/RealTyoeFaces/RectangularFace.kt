package com.example.myproject_hairsalon.AllTypesFaceAndDescrip.RealTyoeFaces

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myproject_hairsalon.Items.FloatingActionRollBack
import com.example.myproject_hairsalon.R
import com.example.myproject_hairsalon.ui.theme.fontCourgette

data class RectangFace(
    @DrawableRes var picture: Int
)

fun getRectangFace(): List<RectangFace> {
    return listOf(
        RectangFace(
            R.drawable.r1
        ),
        RectangFace(
            R.drawable.r2
        ),
        RectangFace(
            R.drawable.r3
        ),
    )
}

@Composable
fun RectangFaceItem(RectangFace: RectangFace, onItemSelected: (RectangFace) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onItemSelected(RectangFace) }
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = RectangFace.picture),
            contentDescription = "Photo of long faces",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .padding(5.dp)
                .size(150.dp)
        )
    }
}

@Composable
fun LazyRowPhotoR(navController: NavHostController) {
    var selectedPicture: RectangFace? by remember { mutableStateOf(null) }

    Column(
        Modifier.fillMaxSize()
    ) {
        LazyColumn {
            item {
                LazyRow {
                    items(getRectangFace()) { RectangFace ->
                        RectangFaceItem(
                            RectangFace = RectangFace
                        ) { selectedPicture = it }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.padding(top = 20.dp))
            }

            item {
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    //La imagen que seleccione el usuario estara en esta variable
                    selectedPicture?.let {//Si no es nulo el valor, se hace lo que va debajo
                        //De lo que ha elegido el user, cogemos la foto
                        Image(
                            painter = painterResource(id = it.picture),
                            //Desripción (que esto da igual)
                            contentDescription = "La imagen que elija el user",
                            //Asignamos el tamañp de la foto
                            modifier = Modifier
                                .padding(bottom = 13.dp)
                                .size(400.dp)
                        )
                    }
                }
            }

            item {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, top = 5.dp),

                    ) {
                    Text(
                        text =
                        "To harmonize a rectangular face, it is key to visually shorten the face, hide the angularity of " +
                                "the chin and add lateral volume.\n\n" +
                                "Avoid a lot of volume at the top, preferring the side part over the middle part.\n\n" +
                                "Straight or side-swept bangs are ideal for the forehead, but avoid curtain bangs if your hair is straight.\n\n" +
                                "In the jaw area, opt for blunt cuts to add volume and hide angularity.\n\n" +
                                "Wavy hairstyles are recommended, avoiding straight hair that highlights the jaw.\n\n" +
                                "For short hair, consider cuts such as the pixie or mullet style to shorten and give lateral volume, " +
                                "avoiding the quiff that lengthens the face.",
                        fontFamily = fontCourgette,
                        modifier = Modifier.padding(5.dp)
                    )
                }
            }

            item {

                Row(
                    Modifier.fillMaxWidth(),
                ) {
                    Box(
                        Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        FloatingActionRollBack(navController)
                    }
                }
            }
        }
    }
}