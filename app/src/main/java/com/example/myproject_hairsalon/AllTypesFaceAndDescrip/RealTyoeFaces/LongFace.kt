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
In this screen we find the characteristics of the Long Face
*/
data class LongFace(
    @DrawableRes var picture: Int
)

//All photos in this class
fun getLongFace(): List<LongFace> {
    return listOf(
        LongFace(
            R.drawable.a1
        ),
        LongFace(
            R.drawable.a4
        ),
        LongFace(
            R.drawable.a2
        ),
        LongFace(
            R.drawable.a5
        ),
        LongFace(
            R.drawable.a3
        ),
    )
}

//How we will see when click in a photo
@Composable
fun LongFaceItem(longFace: LongFace, onItemSelected: (LongFace) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onItemSelected(longFace) }
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = longFace.picture),
            contentDescription = "Photo of long faces",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .padding(5.dp)
                .size(150.dp)
        )
    }
}

//The horizontal list where we will see all pictures of long face and the design of the class
@Composable
fun LazyRowPhotoL(navController: NavHostController) {
    var selectedPicture: LongFace? by remember { mutableStateOf(null) }

    Column(
        Modifier.fillMaxSize()
    ) {
        LazyColumn {
            item {
                LazyRow {
                    items(getLongFace()) { longFace ->
                        LongFaceItem(
                            longFace = longFace
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

            item { Spacer(modifier = Modifier.padding(top = 20.dp)) }

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
                        "To harmonize a long and thin face, it is advisable to visually shorten the face and add lateral volume.\n\n" +
                                "Avoid volume at the top, opt for a side parting or middle parting with bangs.\n\n" +
                                "For the forehead, choose straight or side-swept bangs, avoid curtain bangs with straight hair.\n\n" +
                                "On the jawline, consider bob cuts and chin-length bangs.\n\n" +
                                "The straight cut for medium length hair is favorable, avoid the Bob cut without bangs.\n" +
                                "Waves and side hairstyles are ideal for adding volume.\n\n" +
                                "For short hair, avoid toupees that elongate the face.",
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