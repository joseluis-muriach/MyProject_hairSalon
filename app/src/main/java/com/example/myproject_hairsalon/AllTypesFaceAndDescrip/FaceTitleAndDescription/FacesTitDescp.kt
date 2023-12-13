package com.example.myproject_hairsalon.AllTypesFaceAndDescrip.FaceTitleAndDescription

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myproject_hairsalon.R
import com.example.myproject_hairsalon.ui.theme.fontCourgette

/*
In this class we have the data class for create a face, also we can see the description of all faces of the class
type faces
*/
data class ItemFaceTitDescp(
    @DrawableRes val photo: Int,
    val text: String,
    val description: String
)

//List of Photo, title and description
fun getTypesOfFaces(): List<ItemFaceTitDescp> {
    return listOf(
        ItemFaceTitDescp(
            R.drawable.alargado,
            "LONG FACE",
            "It occurs when the forehead is as wide as the jaw and, in addition, " +
                    "the face is elongated but thin"
        ),
        ItemFaceTitDescp(
            R.drawable.rectangular,
            "RECTANGULAR FACE",
            "It occurs when the face is longer than wide with a high forehead and an elongated jaw."
        ),
        ItemFaceTitDescp(
            R.drawable.redondo,
            "ROUND FACE",
            "It occurs when the length and width of the face are approximately equal, " +
                    "with fuller cheeks and a rounded jaw."
        ),
        ItemFaceTitDescp(
            R.drawable.cuadrado,
            "SQUARE FACE",
            "It occurs when the forehead, cheeks and jaw have similar lines in terms of width, " +
                    "creating an angular appearance"
        ),
        ItemFaceTitDescp(
            R.drawable.pera_triangular,
            "TRIANGLE FACE",
            "It occurs when the forehead is narrow and the jaw is wide, " +
                    "creating an inverted triangular shape."
        ),
        ItemFaceTitDescp(
            R.drawable.corazon,
            "HEART FACE",
            "It occurs when the forehead is wide, but the chin is pointed, " +
                    "creating a shape similar to an inverted heart."
        ),
        ItemFaceTitDescp(
            R.drawable.triangulo_v,
            "INVERTED TRIANGLE F.",
            "It occurs when the forehead is wider than the jaw, creating an " +
                    "inverted triangular shape."
        ),
        ItemFaceTitDescp(
            R.drawable.diamante,
            "DIAMOND FACE",
            "It occurs when the forehead and chin are narrower than the cheeks, " +
                    "with prominent cheekbones."
        ),
        ItemFaceTitDescp(
            R.drawable.ovalado,
            "OVAL FACE",
            "It occurs when the forehead is slightly wider than the chin, " +
                    "with a soft and curved shape."
        ),
    )
}

//Function where create the format
@Composable
fun ItemPhotoAndText(typesOfFaces: ItemFaceTitDescp, onItemClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onItemClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = typesOfFaces.photo),
            contentDescription = "Photo of the faces",
            modifier = Modifier.weight(1f).size(130.dp)
                .padding(10.dp)
        )
        Column(
            modifier = Modifier
                .weight(2.5f)
                .padding(10.dp)
        ){
            Text(
                text = typesOfFaces.text,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 5.dp),
                fontFamily = fontCourgette
                )

            Text(
                text = typesOfFaces.description,
                fontSize = 15.sp
            )
        }
    }
}

//Lazy colum of the real photos when click in a type face
@Composable
fun LazyColumItems(navController: NavController) {
    LazyColumn(
        verticalArrangement = Arrangement.Center
    ){
        items(getTypesOfFaces()) { allItems ->
            ItemPhotoAndText(
                typesOfFaces = allItems,
                onItemClick = {
                    when(allItems.text) {
                        "LONG FACE" -> {
                            navController.navigate("LazyRowPhotoL")
                        }
                        "RECTANGULAR FACE" -> {
                            navController.navigate("LazyRowPhotoR")
                        }
                        "ROUND FACE" -> {
                            navController.navigate("LazyRowPhotoRo")
                        }
                        "SQUARE FACE" -> {
                            navController.navigate("LazyRowPhotoC")
                        }
                        "TRIANGLE FACE" -> {
                            navController.navigate("LazyRowPhotoT")
                        }
                        "HEART FACE" -> {
                            navController.navigate("LazyRowPhotoH")
                        }
                        "DIAMOND FACE" -> {
                            navController.navigate("LazyRowPhotoD")
                        }
                        "OVAL FACE" -> {
                            navController.navigate("LazyRowPhotoO")
                        }
                    }
                }
            )
        }
    }
}
