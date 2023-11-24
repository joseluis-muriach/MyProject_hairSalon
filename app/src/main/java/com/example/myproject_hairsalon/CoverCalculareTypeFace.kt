import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myproject_hairsalon.FloatingButtom
import com.example.myproject_hairsalon.R
import com.example.myproject_hairsalon.WhatIsYourTypeFace.Face
import com.example.myproject_hairsalon.WhatIsYourTypeFace.Face.Companion.calculateYourFace
import com.example.myproject_hairsalon.ui.theme.fontCourgette

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoverTypeFace(navController: NavController) {
    var pointA by remember { mutableStateOf("") }
    var pointB by remember { mutableStateOf("") }
    var pointC by remember { mutableStateOf("") }
    var pointD by remember { mutableStateOf("") }
    var pointE by remember { mutableStateOf("") }
    var textResult by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            Text(
                text = "¿Cuál es tu tipo de cara?",
                fontSize = 30.sp,
                fontFamily = fontCourgette,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .background(Color(0xFFF6CFFF))
            )

            Spacer(modifier = Modifier.padding(15.dp))

            Image(
                painter = painterResource(id = R.drawable.fwtp),
                contentDescription = "Foto con las medidas",
                modifier = Modifier.size(350.dp)
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                text = "· In this section you can see how to take action " +
                        "to determine your face type",
                modifier = Modifier.padding(10.dp),
                fontFamily = fontCourgette
            )

            //The OUTLINEDTEXT where the user will enter the measurements
            OutlinedTextField(
                value = pointA,
                onValueChange = { pointA = it },
                label = {
                    Text("Introduce the punto A: ")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true
            )

            OutlinedTextField(
                value = pointB,
                onValueChange = { pointB = it },
                label = {
                    Text("Introduce the punto B: ")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true
            )

            OutlinedTextField(
                value = pointC,
                onValueChange = { pointC = it },
                label = {
                    Text("Introduce the punto C: ")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true
            )

            OutlinedTextField(
                value = pointD,
                onValueChange = { pointD = it },
                label = {
                    Text("Introduce the punto D: ")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true
            )

            OutlinedTextField(
                value = pointE,
                onValueChange = { pointE = it },
                label = {
                    Text("Introduce the punto E: ")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true
            )
            //End the OULINEDTEXT

            Button(
                onClick = {
                    val userFace =
                        Face(
                            pointA.toFloat(), pointB.toFloat(), pointC.toFloat(), pointD.toFloat(), pointE.toFloat()
                        )
                    textResult = calculateYourFace(userFace)

                    pointA = ""
                    pointB = ""
                    pointC = ""
                    pointD = ""
                    pointE = ""
                },
                modifier =
                Modifier.padding(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF6CFFF))
            ) {

                Text(
                    text = "Calculate",
                    color = Color.Black,
                    fontFamily = fontCourgette
                )
            }

            Text(
                text = textResult,
                modifier = Modifier.padding(10.dp),
                style = TextStyle(
                    fontSize = 20.sp
                )
            )

            Box {
                FloatingButtom(navController)
            }
        }
    }
}
