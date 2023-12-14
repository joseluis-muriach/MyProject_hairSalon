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

/*
In this screen we find the characteristics of the Square Face
*/
data class TriangleFace(
    @DrawableRes var picture: Int
)

//All photos in this class
fun getTriangleFace(): List<TriangleFace> {
    return listOf(
        TriangleFace(
            R.drawable.p1
        ),
        TriangleFace(
            R.drawable.p2
        ),
        TriangleFace(
            R.drawable.p3
        ),
        TriangleFace(
            R.drawable.p4
        ),
        TriangleFace(
            R.drawable.p5
        ),
    )
}

//How we will see when click in
@Composable
fun TriangleFaceItem(TriangleFace: TriangleFace, onItemSelected: (TriangleFace) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onItemSelected(TriangleFace) }
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = TriangleFace.picture),
            contentDescription = "Photo of long faces",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .padding(5.dp)
                .size(150.dp)
        )
    }
}

@Composable
fun LazyRowPhotoT(navController: NavHostController) {
    var selectedPicture: TriangleFace? by remember { mutableStateOf(null) }

    Column(
        Modifier.fillMaxSize()
    ) {
        LazyColumn {
            item {
                LazyRow {
                    items(getTriangleFace()) { TriangleFace ->
                        TriangleFaceItem(
                            TriangleFace = TriangleFace
                        ) {
                            selectedPicture = if (selectedPicture == it) { //If the picture is equal, hidden it
                                null
                            } else {
                                it
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
                    //In this variable the photo will be saved when the user clicks on it
                    selectedPicture?.let {//If the value is not null, we do the following
                        //Take the user photo (when he clicked)
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
                        "This face type has a narrow forehead, prominent cheekbones, and a wider jaw.\n\n" +
                                "To harmonize, add volume on top and soften the angular chin. Opt for a middle or side part to balance hair volume. " +
                                "Choose side-swept or curtain bangs for the forehead and avoid straight bangs.\n\n" +
                                "For the jaw, go for a layered cut from the chin or long straight cuts.\n\n" +
                                "In medium hair, prefer a Bob for elongation, and in short hair, choose voluminous styles like a pompadour, " +
                                "avoiding pixie cuts that frame the face.",
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