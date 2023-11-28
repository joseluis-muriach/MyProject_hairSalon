import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myproject_hairsalon.ui.theme.fontCourgette
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import com.example.myproject_hairsalon.Video


@Composable
fun VideoHowCalculateMyFace(navController: NavController) {
    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {

        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "How to calculate my face?",
                fontSize = 30.sp,
                fontFamily = fontCourgette,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF6CFFF)),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Video()

        Text(
            text = "· In this video you can see how to calculate your face, if you want know " +
                    "what is your face, click in the button ",
            modifier = Modifier.padding(10.dp),
            fontFamily = fontCourgette
        )

        Button(
            onClick = {navController.navigate("HowCalculateFace")},
            modifier = Modifier.padding(10.dp)
                .align(Alignment.End),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF6CFFF))

        ) {
            Text(
                text = "Calculate my face",
                color = Color.Black,
                fontFamily = fontCourgette
            )
        }

//        Box {
//            FloatingButtom(navController)
//        }
    }
}
