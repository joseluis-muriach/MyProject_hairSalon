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
In this screen we find the characteristics of the Heart Face
*/
data class HeartFace(
    @DrawableRes var picture: Int
)

//All photos in this class
fun getHeartFace(): List<HeartFace> {
    return listOf(
        HeartFace(
            R.drawable.h1
        ),
        HeartFace(
            R.drawable.h2
        ),
        HeartFace(
            R.drawable.h3
        ),
        HeartFace(
            R.drawable.h4
        ),
        HeartFace(
            R.drawable.h5
        ),
    )
}

//How we will see when click in a photo
@Composable
fun HeartFaceItem(HeartFace: HeartFace, onItemSelected: (HeartFace) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onItemSelected(HeartFace) }
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = HeartFace.picture),
            contentDescription = "Photo of long faces",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .padding(5.dp)
                .size(150.dp)
        )
    }
}

//The horizontal list where we will see all pictures of heart face and the design of the class
@Composable
fun LazyRowPhotoH(navController: NavHostController) {
    var selectedPicture: HeartFace? by remember { mutableStateOf(null) }

    Column(
        Modifier.fillMaxSize()
    ) {
        LazyColumn {
            item {
                LazyRow {
                    items(getHeartFace()) { HeartFace ->
                        HeartFaceItem(
                            HeartFace = HeartFace
                        ) {
                            selectedPicture = if (selectedPicture == it) {//If the picture is equal, hidden it
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
                        "This face type features a wide forehead, prominent cheekbones, and a narrowing jawline.\n\n" +
                                "To balance, minimize the forehead and add volume to the jaw. Avoid volumizing the top, choose a side or middle part.\n\n" +
                                "For the forehead, opt for straight, side-swept, or curtain bangs.\n\n" +
                                "Add volume to the jaw with layered cuts falling on the face or starting from the chin.·\n\n" +
                                "A straight medium-length cut frames the face. Waves are better than straight hair for lateral volume.\n\n" +
                                "In short hair, consider pixie or asymmetrical styles, avoiding pompadour-like styles that emphasize the wide forehead.",
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