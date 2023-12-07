package com.example.myproject_hairsalon.AllTypesFaceAndDescrip.RealTyoeFaces

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.example.myproject_hairsalon.R

data class LongFace(
    @DrawableRes var picture: Int
)
fun getLongFace(): List<LongFace> {
    return listOf(
        LongFace(
            R.drawable.a1
        ),
        LongFace(
            R.drawable.a2
        ),
        LongFace(
            R.drawable.a3
        ),
    )
}

@Composable
fun LongFaceItem(longFace: LongFace, onItemSelected: (LongFace) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onItemSelected(longFace)}
    ) {
        Image(
            painter = painterResource(id = longFace.picture),
            contentDescription = "Photo of long faces",
            contentScale = ContentScale.Inside,
            modifier = Modifier.padding(5.dp)
        )
    }
}

@Composable
fun LazyRowPhoto(navController: NavHostController) {
    var selectedPicture: LongFace? by remember {mutableStateOf(null)}

    Column(
        Modifier.fillMaxSize()
    ) {
        LazyRow {
            items(getLongFace()) { longFace ->
                LongFaceItem(
                    longFace = longFace
                ) {selectedPicture = it}
            }
        }

        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            //La imagen que seleccione el usuario estara en esta variable
            selectedPicture?.let {//Si no es nulo el valor, se hace lo que va debajo
                //De lo que ha elegido el user, cogemos la foto
                Image(painter = painterResource(id = it.picture),
                    //Desripción (que esto da igual)
                    contentDescription = "La imagen que elija el user",
                    //Asignamos el tamañp de la foto
                    modifier = Modifier.size(500.dp).padding(5.dp))
            }
        }
    }
}