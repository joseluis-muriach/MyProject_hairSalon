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

/*TENGO QUE CAMBIAR LAS FOTOS*/
data class OvalFace(
    @DrawableRes var picture: Int
)

fun getOvalFace(): List<OvalFace> {
    return listOf(
        OvalFace(
            R.drawable.ov1
        ),
        OvalFace(
            R.drawable.ov2
        ),
        OvalFace(
            R.drawable.ov3
        ),
        OvalFace(
            R.drawable.ov4
        ),
        OvalFace(
            R.drawable.ov5
        ),
    )
}

@Composable
fun OvalFaceItem(OvalFace: OvalFace, onItemSelected: (OvalFace) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onItemSelected(OvalFace) }
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = OvalFace.picture),
            contentDescription = "Photo of long faces",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .padding(5.dp)
                .size(150.dp)
        )
    }
}

@Composable
fun LazyRowPhotoO(navController: NavHostController) {
    var selectedPicture: OvalFace? by remember { mutableStateOf(null) }

    Column(
        Modifier.fillMaxSize()
    ) {
        LazyColumn {
            item {
                LazyRow {
                    items(getOvalFace()) { OvalFace ->
                        OvalFaceItem(
                            OvalFace = OvalFace
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
                        "The oval face is considered the perfect face shape and requires no corrections.\n\n" +
                                "It is deemed ideal because neither the cheekbones nor the jawline is too prominent, " +
                                "maintaining balanced proportions.\n\n" +
                                "Therefore, other face shapes may be accentuated to resemble an oval face.",
                        fontFamily = fontCourgette,
                        modifier = Modifier.padding(10.dp)
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