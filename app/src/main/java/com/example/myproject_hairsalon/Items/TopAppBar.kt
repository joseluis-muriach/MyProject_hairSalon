package com.example.myproject_hairsalon.Items

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
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
//La top bar siempre va en el Scaffol que lo pondremos en nuestra pantalla principal, no en el MAIN
    TopAppBar(
        //Siempre pondremos el titulo primero y luego lo demas
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
        navigationIcon = { //Aquí pondremos el botton que queramos que haga la acción
            IconButton(onClick = { navController.navigate("MainCover") }) { //En el onclick, en este caso no hará nada
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "",
                    tint = Color.Black
                )
            }
        },
        actions = { //Para poner los tres puntos o cualquier icono a la derecha
            //Variable la cual la creamos por que en el MoreVert tenemos varias opciones
            var showMenu by remember { mutableStateOf(false) }
            //Haciendo click el lambda cambia de false a true o viceversa
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Desplegable de dos opciones",
                    tint = Color.Black
                )
            }
            //Creamos el drop menu por que tenemos varias opciones dentro de MoreVert
            DropdownMenu(
                expanded = showMenu, //Controla si el menu está expandido o no
                //Un lambda que se ejecuta cuando el usuario cierra el menú
                onDismissRequest = { showMenu = false },
                //Modificador que establece el ancho del menú desplegable
                Modifier.width(150.dp)
            ) {
                DropdownMenuItem( //Esta línea crea un elemento de menú desplegable
                    text = { Text(text = "Compartir") },
                    onClick = { /*TODO*/ }, //No queremos que haga nada
                    leadingIcon = { //Un icono que se muestra antes del texto del elemento
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "share"
                        )
                    }
                )
                DropdownMenuItem( //Por cada icono tenemos que hacer un DropdownMenu
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

//TopAppBar of what is your face type
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarB(navController: NavController) {
//La top bar siempre va en el Scaffol que lo pondremos en nuestra pantalla principal, no en el MAIN
    TopAppBar(
        //Siempre pondremos el titulo primero y luego lo demas
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
        navigationIcon = { //Aquí pondremos el botton que queramos que haga la acción
            IconButton(onClick = { navController.navigate("MainCover") }) { //En el onclick, en este caso no hará nada
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "",
                    tint = Color.Black
                )
            }
        },
        actions = { //Para poner los tres puntos o cualquier icono a la derecha
            //Variable la cual la creamos por que en el MoreVert tenemos varias opciones
            var showMenu by remember { mutableStateOf(false) }
            //Haciendo click el lambda cambia de false a true o viceversa
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Desplegable de dos opciones",
                    tint = Color.Black
                )
            }
            //Creamos el drop menu por que tenemos varias opciones dentro de MoreVert
            DropdownMenu(
                expanded = showMenu, //Controla si el menu está expandido o no
                //Un lambda que se ejecuta cuando el usuario cierra el menú
                onDismissRequest = { showMenu = false },
                //Modificador que establece el ancho del menú desplegable
                Modifier.width(150.dp)
            ) {
                DropdownMenuItem( //Esta línea crea un elemento de menú desplegable
                    text = { Text(text = "Compartir") },
                    onClick = { /*TODO*/ }, //No queremos que haga nada
                    leadingIcon = { //Un icono que se muestra antes del texto del elemento
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "share"
                        )
                    }
                )
                DropdownMenuItem( //Por cada icono tenemos que hacer un DropdownMenu
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

//TopAppBar of type of faces
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarC(navController: NavController) {
//La top bar siempre va en el Scaffol que lo pondremos en nuestra pantalla principal, no en el MAIN
    TopAppBar(
        //Siempre pondremos el titulo primero y luego lo demas
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
        navigationIcon = { //Aquí pondremos el botton que queramos que haga la acción
            IconButton(onClick = { navController.navigate("MainCover") }) { //En el onclick, en este caso no hará nada
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "",
                    tint = Color.Black
                )
            }
        },
        actions = { //Para poner los tres puntos o cualquier icono a la derecha
            //Variable la cual la creamos por que en el MoreVert tenemos varias opciones
            var showMenu by remember { mutableStateOf(false) }
            //Haciendo click el lambda cambia de false a true o viceversa
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Desplegable de dos opciones",
                    tint = Color.Black
                )
            }
            //Creamos el drop menu por que tenemos varias opciones dentro de MoreVert
            DropdownMenu(
                expanded = showMenu, //Controla si el menu está expandido o no
                //Un lambda que se ejecuta cuando el usuario cierra el menú
                onDismissRequest = { showMenu = false },
                //Modificador que establece el ancho del menú desplegable
                Modifier.width(150.dp)
            ) {
                DropdownMenuItem( //Esta línea crea un elemento de menú desplegable
                    text = { Text(text = "Compartir") },
                    onClick = { /*TODO*/ }, //No queremos que haga nada
                    leadingIcon = { //Un icono que se muestra antes del texto del elemento
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "share"
                        )
                    }
                )
                DropdownMenuItem( //Por cada icono tenemos que hacer un DropdownMenu
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

//La top de la cover principal
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
//La top bar siempre va en el Scaffol que lo pondremos en nuestra pantalla principal, no en el MAIN
    TopAppBar(
        //Siempre pondremos el titulo primero y luego lo demas
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
        navigationIcon = { //Aquí pondremos el botton que queramos que haga la acción
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
            ) { //En el onclick, en este caso no hará nada
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "",
                    tint = Color.Black
                )
            }
        },

        actions = { //Para poner los tres puntos o cualquier icono a la derecha
            //Variable la cual la creamos por que en el MoreVert tenemos varias opciones
            var showMenu by remember { mutableStateOf(false) }
            //Haciendo click el lambda cambia de false a true o viceversa
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Desplegable de dos opciones",
                    tint = Color.Black
                )
            }
            //Creamos el drop menu por que tenemos varias opciones dentro de MoreVert
            DropdownMenu(
                expanded = showMenu, //Controla si el menu está expandido o no
                //Un lambda que se ejecuta cuando el usuario cierra el menú
                onDismissRequest = { showMenu = false },
                //Modificador que establece el ancho del menú desplegable
                Modifier.width(150.dp)
            ) {
                DropdownMenuItem( //Esta línea crea un elemento de menú desplegable
                    text = { Text(text = "Compartir") },
                    onClick = { /*TODO*/ }, //No queremos que haga nada
                    leadingIcon = { //Un icono que se muestra antes del texto del elemento
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "share"
                        )
                    }
                )
                DropdownMenuItem( //Por cada icono tenemos que hacer un DropdownMenu
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