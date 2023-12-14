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
data class SquareFace(
    @DrawableRes var picture: Int
)

//All photos in this class
fun getSquareFace(): List<SquareFace> {
    return listOf(
        SquareFace(
            R.drawable.c1
        ),
        SquareFace(
            R.drawable.c2
        ),
        SquareFace(
            R.drawable.c3
        ),
        SquareFace(
            R.drawable.c4
        ),
        SquareFace(
            R.drawable.c5
        ),
    )
}

//How we will see when click in
@Composable
fun SquareFaceItem(SquareFace: SquareFace, onItemSelected: (SquareFace) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onItemSelected(SquareFace) }
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = SquareFace.picture),
            contentDescription = "Photo of long faces",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .padding(5.dp)
                .size(150.dp)
        )
    }
}

@Composable
fun LazyRowPhotoC(navController: NavHostController) {
    var selectedPicture: SquareFace? by remember { mutableStateOf(null) }

    Column(
        Modifier.fillMaxSize()
    ) {
        LazyColumn {
            item {
                LazyRow {
                    items(getSquareFace()) { SquareFace ->
                        SquareFaceItem(
                            SquareFace = SquareFace
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
                        "A short face with equal-width features seeks elongation and jaw angle disguise.\n\n" +
                                "Avoid framing and lateral volume. Opt for voluminous hairstyles with a middle or side part to lengthen the face.\n\n" +
                                "Choose side-swept or curtain bangs to avoid framing, while avoiding straight bangs.\n\n" +
                                "For the jaw, consider layered cuts from the chin or long straight cuts.\n\n" +
                                "In medium hair, prefer a Bob for elongation; in short hair, go for volume like a pompadour, avoiding pixie styles that frame the face.",
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