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

data class RoundFace(
    @DrawableRes var picture: Int
)

fun getRoundFace(): List<RoundFace> {
    return listOf(
        RoundFace(
            R.drawable.red1
        ),
        RoundFace(
            R.drawable.red2
        ),
        RoundFace(
            R.drawable.red3
        ),
    )
}

@Composable
fun RoundFaceItem(RoundFace: RoundFace, onItemSelected: (RoundFace) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onItemSelected(RoundFace) }
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = RoundFace.picture),
            contentDescription = "Photo of long faces",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .padding(5.dp)
                .size(150.dp)
        )
    }
}

@Composable
fun LazyRowPhotoRo(navController: NavHostController) {
    var selectedPicture: RoundFace? by remember { mutableStateOf(null) }

    Column(
        Modifier.fillMaxSize()
    ) {
        LazyColumn {
            item {
                LazyRow {
                    items(getRoundFace()) { RoundFace ->
                        RoundFaceItem(
                            RoundFace = RoundFace
                        ) {
                            if (selectedPicture == it) {
                                // Si la imagen seleccionada es la misma, ocultarla
                                selectedPicture = null
                            } else {
                                selectedPicture = it
                            }
                        }
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
                        "To harmonize a rounded and short face, we seek to visually lengthen and narrow it.\n\n" +
                                "At the top, it is recommended to add volume with a side or middle part. " +
                                "Side or curtain bangs are ideal for the forehead, avoiding straight ones.\n\n" +
                                "On the jaw, stepped cuts should start from the chin for length, and straight cuts " +
                                "should be long. On medium hair, the Bob style is preferable.\n\n" +
                                "For short hair, opt for pompadours and asymmetrical cuts to add volume, avoiding the pixie " +
                                "that frames the face.",
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