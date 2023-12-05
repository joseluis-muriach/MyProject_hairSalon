package com.example.myproject_hairsalon.Cover

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myproject_hairsalon.Items.FloatingButton
import com.example.myproject_hairsalon.Items.MyTopAppBarCM
import com.example.myproject_hairsalon.R
import com.example.myproject_hairsalon.ui.theme.fontCourgette
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainCoverVertical(navController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val items = listOf(
        Pair(Icons.Default.PlayArrow, "How calculate my type face"),
        Pair(Icons.Default.Create, "Calculate your type face"),
        Pair(Icons.Default.AccountCircle, "Types faces")
    )
    val selectedItem = remember {
        mutableStateOf(items[0])
    }

    Scaffold(
        topBar = { MyTopAppBarCM(navController, drawerState, scope) }
    ) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet(
                    Modifier.padding(top = it.calculateTopPadding())
                ){
                    Image(
                        painter = painterResource(id = R.drawable.portadapelu),
                        contentDescription = "Image portada",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    items.forEach { (itemIcon, itemName) ->
                        NavigationDrawerItem(
                            icon = { Icon(itemIcon, contentDescription = null) },
                            label = {
                                Text(
                                    text = itemName,
                                    fontFamily = fontCourgette,
                                )
                            },
                            selected = itemIcon == selectedItem.value.first,
                            onClick = {
                                scope.launch { drawerState.close() }
                                selectedItem.value = Pair(itemIcon, itemName)
                                // Haz algo con el nombre personalizado (itemName) o ícono (itemIcon)
                                navController.navigate(itemName)
                            }
                        )
                    }
                }
            },
            content = {
                Column(
                    Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.logoandrea2),
                        contentDescription = "app picture",
                        modifier = Modifier
                            .size(220.dp)
//                    .border(2.dp, Color.Black, CircleShape)
//                    .clip(shape = RoundedCornerShape(40.dp))
                    )

                    Spacer(modifier = Modifier.padding(15.dp))

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Salón Dea",
                            fontFamily = fontCourgette,
                            fontSize = 50.sp
                        )
                    }
                }

                Row(
                    Modifier.fillMaxWidth()
                ) {
                    Box(
                        Modifier
                            .padding(top = 16.dp)
                            .fillMaxSize(),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        FloatingButton(
                            navController, "https://instagram.com/andrea.laslo?igshid=OGQ5ZDc2ODk2ZA=="
                        )
                    }

                    Box(
                        Modifier
                            .padding(top = 16.dp)
                            .fillMaxSize(),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        IconButton(
                            onClick = {},
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = null,
                                tint = Color.Black
                            )
                        }
                    }
                }
            }
        )
    }
}