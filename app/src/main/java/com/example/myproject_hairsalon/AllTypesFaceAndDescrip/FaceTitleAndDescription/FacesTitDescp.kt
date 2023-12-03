package com.example.myproject_hairsalon.AllTypesFaceAndDescrip.FaceTitleAndDescription

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
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
import com.example.myproject_hairsalon.R
import com.example.myproject_hairsalon.ui.theme.fontCourgette

//Data base
data class itemFaceTitDescp(
    @DrawableRes val photo: Int,
    val text: String,
    val description: String
)

//List of Photo, title and description
fun getTypesOfFaces(): List<itemFaceTitDescp> {
    return listOf(
        itemFaceTitDescp(
            R.drawable.alargado,
            "ROSTRO ALARGADO",
            "Se da cuando la frente es tan ancha como la mandibula y, además el rostro es " +
                    "alargado pero fino"
        ),
        itemFaceTitDescp(
            R.drawable.rectangular,
            "ROSTRO RECTANGULAR",
            "Se da cuando la cara es mas larga que ancha, " +
                    "con una frente alta y una mandibula alargada"
        ),
        itemFaceTitDescp(
            R.drawable.redondo,
            "ROSTRO REDONDO",
            "Se da cuando la longitud y el ancho de la cara son " +
                    "aproximadamente iguales, con mejillas mas llenas y una " +
                    "mandibula redondeada"
        ),
        itemFaceTitDescp(
            R.drawable.cuadrado,
            "ROSTRO CUADRADO",
            "Se da cuando la frente, las mejillas y la mandibula tienen líneas " +
                    "similares en términos de anchura, creando una apariencia angular"
        ),
        itemFaceTitDescp(
            R.drawable.pera_triangular,
            "ROSTRO PERA/ROSTRO TRIANGULAR",
            "Se da cuando la frente es estrecha y la mandíbula es ancha, creando una forma " +
                    "triangular invertida"
        ),
        itemFaceTitDescp(
            R.drawable.corazon,
            "ROSTRO CORAZÓN",
            "Se da cuando la frente es ancha, pero la barbilla es puntiaguda, " +
                    "creando una forma similar a un corazón invertido."
        ),
        itemFaceTitDescp(
            R.drawable.triangulo_v,
            "R. TRIÁNGULO INVERTIDO",
            "Se da cuando la frente es más ancha que la mandíbula, creando una forma " +
                    "triangular invertida."
        ),
        itemFaceTitDescp(
            R.drawable.diamante,
            "ROSTRO DIAMANTE",
            "Se da cuando la frente y la barbilla son más estrechas que las mejillas, " +
                    "con pómulos prominentes."
        ),
        itemFaceTitDescp(
            R.drawable.ovalado,
            "ROSTRO OVALADO",
            "Se da cuando la frente es ligeramente más ancha que la barbilla, " +
                    "con una forma suave y curvada."
        ),
    )
}

//Function where create the format
@Composable
fun ItemPhotoAndText(typesOfFaces: itemFaceTitDescp) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
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

@Composable
fun LazyColumItems() {
    LazyColumn(
        verticalArrangement = Arrangement.Center
    ){
        items(getTypesOfFaces()) { allItems ->
            ItemPhotoAndText(
                typesOfFaces = allItems
            )
        }
    }
}
