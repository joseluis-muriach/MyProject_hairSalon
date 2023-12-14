package com.example.myproject_hairsalon.Items

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myproject_hairsalon.R
import com.example.myproject_hairsalon.ui.theme.fontCourgette
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/*
In this screen we can see how to create the top app bar (There are four top app bar)
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(navController: NavController) {
    //The top app bar always inside of scaffol
    TopAppBar(
        //Allways first the title
        title = {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "How to calculate my face",
                    color = Color.Black,
                    fontFamily = fontCourgette,
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(0xFFF3DFF8)),
        navigationIcon = { //Buttom that make the action
            IconButton(
                onClick = {
                    navController.navigate("MainCover")
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "",
                    tint = Color.Black
                )
            }
        },
        actions = { //For add the three points menu or other icon to right side
            //Create this variable because in MoreVert has more options
            var showMenu by remember { mutableStateOf(false) }
            //If click in lambda, this change to false or true or true to false
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Desplegable de dos opciones",
                    tint = Color.Black
                )
            }
            //Create the drop menu because we have more options inside to MoreVert
            DropdownMenu(
                expanded = showMenu, //This controlate if the manu is expanded or not
                //A lambda be execute when the user close the menu
                onDismissRequest = { showMenu = false },
                //Modifier that sets the width of the dropdown menu
                Modifier.width(150.dp)
            ) {
                DropdownMenuItem( //This line creates a dropdown menu item.
                    text = { Text(text = "Home") },
                    onClick = { navController.navigate("MainCover") },
                    leadingIcon = { //A icon that show before the text of element
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "home"
                        )
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = "Type faces") },
                    onClick = { navController.navigate("Types faces") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "faces"
                        )
                    }
                )
            }
        }
    )
}

//TopAppBar of what is your face type
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarB(navController: NavController) {
    TopAppBar(
        title = {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "What's you face type",
                    color = Color.Black,
                    fontFamily = fontCourgette,
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(0xFFF3DFF8)),
        navigationIcon = {
            IconButton(onClick = { navController.navigate("MainCover") }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "",
                    tint = Color.Black
                )
            }
        },
        actions = {
            var showMenu by remember { mutableStateOf(false) }

            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Desplegable de dos opciones",
                    tint = Color.Black
                )
            }

            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
                Modifier.width(150.dp)
            ) {
                DropdownMenuItem(
                    text = { Text(text = "Home") },
                    onClick = { navController.navigate("MainCover") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "home"
                        )
                    }
                )
            }
        }
    )
}

//TopAppBar of type of faces
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarC(navController: NavController) {
    TopAppBar(
        title = {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Type of faces",
                    color = Color.Black,
                    fontFamily = fontCourgette,
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(0xFFF3DFF8)),
        navigationIcon = {
            IconButton(onClick = { navController.navigate("MainCover") }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "",
                    tint = Color.Black
                )
            }
        },
        actions = {
            var showMenu by remember { mutableStateOf(false) }
            IconButton(onClick = { showMenu = !showMenu }) {

                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Desplegable de dos opciones",
                    tint = Color.Black
                )
            }

            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
                Modifier.width(150.dp)
            ) {
                DropdownMenuItem(
                    text = { Text(text = "Home") },
                    onClick = { navController.navigate("MainCover") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "home"
                        )
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = "How calculate") },
                    onClick = { navController.navigate("MainHowCalcFace") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.PlayArrow,
                            contentDescription = "video calculate face"
                        )
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = "Calculate face") },
                    onClick = { navController.navigate("Calculate your type face") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Create,
                            contentDescription = "Calculate face"
                        )
                    }
                )
            }
        }
    )
}

//The top of the main cover
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarCM(
    navController: NavController,
    drawerState: DrawerState,
    scope: CoroutineScope,
) {
    var modalNav by remember { mutableStateOf(false) }
    var modalNavIsOn by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Welcome",
                    color = Color.Black,
                    fontFamily = fontCourgette,
                    fontSize = 30.sp
                )
            }
        },

        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(0xFFF3DFF8)),
        navigationIcon = {
            IconButton(
                onClick = {
                    modalNav = !modalNav
                    if (modalNav) {
                        scope.launch { drawerState.open() }
                        modalNavIsOn = true
                    } else {
                        scope.launch { drawerState.close() }
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "",
                    tint = Color.Black
                )
            }
        },

        actions = {
            var showMenu by remember { mutableStateOf(false) }

            IconButton(onClick = { showMenu = !showMenu }) {

            }

            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
                Modifier.width(150.dp)
            ) {
                DropdownMenuItem(
                    text = { Text(text = "Compartir") },
                    onClick = { /*TODO*/ },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "share"
                        )
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = "Type faces") },
                    onClick = { /*TODO*/ },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.AccountBox,
                            contentDescription = "faces"
                        )
                    }
                )
            }
        }
    )
}