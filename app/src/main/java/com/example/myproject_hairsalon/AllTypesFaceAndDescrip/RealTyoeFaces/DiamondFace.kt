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
In this screen we find the characteristics of the Diamond Face
*/
data class DiamondFace(
    @DrawableRes var picture: Int
)

//All photos in this class
fun getDiamondFace(): List<DiamondFace> {
    return listOf(
        DiamondFace(
            R.drawable.d1
        ),
        DiamondFace(
            R.drawable.d2
        ),
        DiamondFace(
            R.drawable.d3
        ),
        DiamondFace(
            R.drawable.d4
        ),
        DiamondFace(
            R.drawable.d5
        ),
    )
}

//How we will see when click in a photo
@Composable
fun DiamondFaceItem(DiamondFace: DiamondFace, onItemSelected: (DiamondFace) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onItemSelected(DiamondFace) }
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = DiamondFace.picture),
            contentDescription = "Photo of long faces",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .padding(5.dp)
                .size(150.dp)
        )
    }
}

//The horizontal list where we will see all pictures of diamond face and the design of the class
@Composable
fun LazyRowPhotoD(navController: NavHostController) {
    var selectedPicture: DiamondFace? by remember { mutableStateOf(null) }

    Column(
        Modifier.fillMaxSize()
    ) {
        LazyColumn {
            item {
                LazyRow {
                    items(getDiamondFace()) { DiamondFace ->
                        DiamondFaceItem(
                            DiamondFace = DiamondFace
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
                            contentDescription = "La imagen que elija el user",
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
                        "This face type has a narrow forehead and chin, with prominent cheekbones.\n\n" +
                                "To harmonize, add volume to the forehead and chin, softening cheekbone angles.\n\n" +
                                "Opt for a middle or side part. Any bangs style works, and a layered cut, either above or below the face, " +
                                "complements the cheekbones. Straight hair disguises cheekbone angles.\n\n" +
                                "In short hair, choose pixie or asymmetrical styles, and consider a pompadour-like style based on cheekbone prominence.",
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