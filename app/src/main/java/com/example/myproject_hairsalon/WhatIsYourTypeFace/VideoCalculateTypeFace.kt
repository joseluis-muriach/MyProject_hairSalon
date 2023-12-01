import android.annotation.SuppressLint
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import com.example.myproject_hairsalon.Items.MyTopAppBar
import com.example.myproject_hairsalon.Video


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoHowCalculateMyFace(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MyTopAppBar(navController) }
    ) {

        Column(
            modifier = Modifier.padding(top = it.calculateTopPadding())
        ) {
            Video()
            Text(
                text = "· In this video you can see how to calculate your face, if you want know " +
                        "what is your face, click in the button ",
                modifier = Modifier.padding(16.dp),
                fontFamily = fontCourgette
            )
            Button(
                onClick = { navController.navigate("HowCalculateFace") },
                modifier = Modifier
                    .padding(top = 7.dp, start = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF6CFFF))

            ) {
                Text(
                    text = "Calculate my face",
                    color = Color.Black,
                    fontFamily = fontCourgette
                )

            }
        }
    }

}
