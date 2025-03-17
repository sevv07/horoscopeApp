@file:OptIn(ExperimentalMaterial3Api::class)

package com.sevval.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.text.CaseMap.Title
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sevval.myapplication.ui.theme.Black
import com.sevval.myapplication.ui.theme.Pink40
import com.sevval.myapplication.ui.theme.Pink8
import com.sevval.myapplication.ui.theme.Pink80
import com.sevval.myapplication.ui.theme.Purple40
import com.sevval.myapplication.ui.theme.Purple80
import com.sevval.myapplication.ui.theme.PurpleGrey40
import com.sevval.myapplication.ui.theme.PurpleGrey80
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sevval.myapplication.ui.theme.Profile
import com.sevval.myapplication.ui.theme.Screen
import com.sevval.myapplication.ui.theme.SgnAr
import com.sevval.myapplication.ui.theme.SgnBa
import com.sevval.myapplication.ui.theme.SgnOg
import com.sevval.myapplication.ui.theme.SgnYe
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    val uriHandler = LocalUriHandler.current

    val navControl = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current.applicationContext

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .height(150.dp)
                ) {
                    Text(text = "Menu")
                }
                Divider()
                NavigationDrawerItem(label = { Text(text = "Home", color = Pink40) },
                    selected = false,
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navControl.navigate(Screen.HomeScreen.route) {
                            popUpTo(0)
                        }
                    })
                NavigationDrawerItem(label = { Text(text = "Profile", color = Pink40) },
                    selected = false,
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navControl.navigate(Screen.Profile.route)
                    })
                NavigationDrawerItem(label = { Text(text = "logout", color = Pink40) },
                    selected = false,
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        Toast.makeText(context, "logout", Toast.LENGTH_SHORT).show()
                    })
            }
        },
    ) {
        Scaffold(
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                TopAppBar(title = { Text(text = "Home Page") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Pink40,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                Icons.Rounded.Menu, contentDescription = "menuButton"
                            )
                        }
                    })
            }
        ) {
            NavHost(navController = navControl, startDestination = "Log ın") {
                composable(route = "Log ın") { Logın(navControl) }
                composable(Screen.Profile.route) { Profile() }
                composable(Screen.HomeScreen.route) { HomeScreen(navControl) }

            }

            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Purple80)
            ) {
                item {
                    Spacer(modifier = Modifier.height(100.dp))

                    Button(onClick = {
                        // Anket linkini aç
                        uriHandler.openUri("https://docs.google.com/forms/d/1sz33N4Kau3mRmrsEBxjAaacuA9_3S7FUjVMJnO-SrlA/edit")
                    }) {
                        Text("Fill in the Zodiac Test")
                    }


                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Horoscopes", fontSize = 20.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Serif
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .background(PurpleGrey40)
                            .border(3.dp, Color.White)
                            .padding(20.dp)
                            .height(120.dp)
                            .width(330.dp)
                            .clip(RoundedCornerShape(20.dp))
                    )
                    {
                        Spacer(modifier = Modifier.height(10.dp))
                        Row {
                            Card(
                                modifier = Modifier
                                    .border(3.dp, Color.Black)
                                    .height(100.dp)
                                    .width(330.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(PurpleGrey40),
                                elevation = CardDefaults.cardElevation(10.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("SgnBa")
                                        },
                                        shape = CutCornerShape(10),
                                        border = BorderStroke(2.dp, Color.White)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.psces),
                                            contentDescription = "Pisces",
                                            Modifier
                                                .width(900.dp)
                                                .height(900.dp)
                                        )
                                    }
                                }
                            }


                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .background(PurpleGrey40)
                            .border(3.dp, Color.White)
                            .padding(20.dp)
                            .height(120.dp)
                            .width(330.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    {
                        Spacer(modifier = Modifier.height(5.dp))
                        Row {
                            Card(
                                modifier = Modifier
                                    .border(3.dp, Color.Black)
                                    .height(100.dp)
                                    .width(330.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(PurpleGrey40),
                                elevation = CardDefaults.cardElevation(10.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("SgnOg")
                                        },
                                        shape = CutCornerShape(10),
                                        border = BorderStroke(2.dp, Color.White)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.og),
                                            contentDescription = "Capricorn",
                                            Modifier
                                                .width(900.dp)
                                                .height(900.dp)
                                        )
                                    }
                                }
                            }

                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .background(PurpleGrey40)
                            .border(3.dp, Color.White)
                            .padding(20.dp)
                            .height(120.dp)
                            .width(330.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    {
                        Spacer(modifier = Modifier.height(5.dp))
                        Row {
                            Card(
                                modifier = Modifier
                                    .border(3.dp, Color.Black)
                                    .height(100.dp)
                                    .width(330.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(PurpleGrey40),
                                elevation = CardDefaults.cardElevation(10.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("SgnAr")
                                        },
                                        shape = CutCornerShape(10),
                                        border = BorderStroke(1.dp, Color.White)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.k),
                                            contentDescription = "Aries",
                                            Modifier
                                                .width(900.dp)
                                                .height(900.dp)
                                        )
                                    }
                                }
                            }

                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .background(PurpleGrey40)
                            .border(3.dp, Color.White)
                            .padding(20.dp)
                            .height(120.dp)
                            .width(330.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    {
                        Spacer(modifier = Modifier.height(5.dp))
                        Row {
                            Card(
                                modifier = Modifier
                                    .border(3.dp, Color.Black)
                                    .height(100.dp)
                                    .width(330.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(PurpleGrey40),
                                elevation = CardDefaults.cardElevation(10.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("SgnYe")
                                        },
                                        shape = CutCornerShape(10),
                                        border = BorderStroke(1.dp, Color.White)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.y),
                                            contentDescription = "Cancer",
                                            Modifier
                                                .width(900.dp)
                                                .height(900.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .background(PurpleGrey40)
                            .border(3.dp, Color.White)
                            .padding(20.dp)
                            .height(120.dp)
                            .width(330.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    {
                        Spacer(modifier = Modifier.height(5.dp))
                        Row {
                            Card(
                                modifier = Modifier
                                    .border(3.dp, Color.Black)
                                    .height(100.dp)
                                    .width(330.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(PurpleGrey40),
                                elevation = CardDefaults.cardElevation(10.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("SgnAqua")
                                        },
                                        shape = CutCornerShape(10),
                                        border = BorderStroke(1.dp, Color.White)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.aqus),
                                            contentDescription = "aqus",
                                            Modifier
                                                .width(900.dp)
                                                .height(900.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .background(PurpleGrey40)
                            .border(3.dp, Color.White)
                            .padding(20.dp)
                            .height(120.dp)
                            .width(330.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    {
                        Spacer(modifier = Modifier.height(5.dp))
                        Row {
                            Card(
                                modifier = Modifier
                                    .border(3.dp, Color.Black)
                                    .height(100.dp)
                                    .width(330.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(PurpleGrey40),
                                elevation = CardDefaults.cardElevation(10.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("SgnLeo")
                                        },
                                        shape = CutCornerShape(10),
                                        border = BorderStroke(1.dp, Color.White)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.leo),
                                            contentDescription = "Cancer",
                                            Modifier
                                                .width(900.dp)
                                                .height(900.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .background(PurpleGrey40)
                            .border(3.dp, Color.White)
                            .padding(20.dp)
                            .height(120.dp)
                            .width(330.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    {
                        Spacer(modifier = Modifier.height(5.dp))
                        Row {
                            Card(
                                modifier = Modifier
                                    .border(3.dp, Color.Black)
                                    .height(100.dp)
                                    .width(330.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(PurpleGrey40),
                                elevation = CardDefaults.cardElevation(10.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("SgnGemini")
                                        },
                                        shape = CutCornerShape(10),
                                        border = BorderStroke(1.dp, Color.White)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.ba),
                                            contentDescription = "Cancer",
                                            Modifier
                                                .width(900.dp)
                                                .height(900.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .background(PurpleGrey40)
                            .border(3.dp, Color.White)
                            .padding(20.dp)
                            .height(120.dp)
                            .width(330.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    {
                        Spacer(modifier = Modifier.height(5.dp))
                        Row {
                            Card(
                                modifier = Modifier
                                    .border(3.dp, Color.Black)
                                    .height(100.dp)
                                    .width(330.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(PurpleGrey40),
                                elevation = CardDefaults.cardElevation(10.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("SgnSagtt")
                                        },
                                        shape = CutCornerShape(10),
                                        border = BorderStroke(1.dp, Color.White)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.sagtarus),
                                            contentDescription = "Cancer",
                                            Modifier
                                                .width(900.dp)
                                                .height(900.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .background(PurpleGrey40)
                            .border(3.dp, Color.White)
                            .padding(20.dp)
                            .height(120.dp)
                            .width(330.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    {
                        Spacer(modifier = Modifier.height(5.dp))
                        Row {
                            Card(
                                modifier = Modifier
                                    .border(3.dp, Color.Black)
                                    .height(100.dp)
                                    .width(330.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(PurpleGrey40),
                                elevation = CardDefaults.cardElevation(10.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("SgnScorp")
                                        },
                                        shape = CutCornerShape(10),
                                        border = BorderStroke(1.dp, Color.White)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.scorpo),
                                            contentDescription = "Cancer",
                                            Modifier
                                                .width(900.dp)
                                                .height(900.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .background(PurpleGrey40)
                            .border(3.dp, Color.White)
                            .padding(20.dp)
                            .height(120.dp)
                            .width(330.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    {
                        Spacer(modifier = Modifier.height(5.dp))
                        Row {
                            Card(
                                modifier = Modifier
                                    .border(3.dp, Color.Black)
                                    .height(100.dp)
                                    .width(330.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(PurpleGrey40),
                                elevation = CardDefaults.cardElevation(10.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("SgnTaurus")
                                        },
                                        shape = CutCornerShape(10),
                                        border = BorderStroke(1.dp, Color.White)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.taurus),
                                            contentDescription = "Cancer",
                                            Modifier
                                                .width(900.dp)
                                                .height(900.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .background(PurpleGrey40)
                            .border(3.dp, Color.White)
                            .padding(20.dp)
                            .height(120.dp)
                            .width(330.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    {
                        Spacer(modifier = Modifier.height(5.dp))
                        Row {
                            Card(
                                modifier = Modifier
                                    .border(3.dp, Color.Black)
                                    .height(100.dp)
                                    .width(330.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(PurpleGrey40),
                                elevation = CardDefaults.cardElevation(10.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("SgnVrgo")
                                        },
                                        shape = CutCornerShape(10),
                                        border = BorderStroke(1.dp, Color.White)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.vrgo),
                                            contentDescription = "Cancer",
                                            Modifier
                                                .width(900.dp)
                                                .height(900.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .background(PurpleGrey40)
                            .border(3.dp, Color.White)
                            .padding(20.dp)
                            .height(120.dp)
                            .width(330.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    {
                        Spacer(modifier = Modifier.height(5.dp))
                        Row {
                            Card(
                                modifier = Modifier
                                    .border(3.dp, Color.Black)
                                    .height(100.dp)
                                    .width(330.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(PurpleGrey40),
                                elevation = CardDefaults.cardElevation(10.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Button(
                                        onClick = {
                                            navController.navigate("SgnLbra")
                                        },
                                        shape = CutCornerShape(10),
                                        border = BorderStroke(1.dp, Color.White)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.kova),
                                            contentDescription = "Cancer",
                                            Modifier
                                                .width(900.dp)
                                                .height(900.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(900.dp))

                }
            }
        }
    }
}






    /*
    var search by remember { mutableStateOf(" ") }
    val tur=listOf("comedia","action","romantic","dram")
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()
            .background(Purple80)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxWidth()
        ) {
            boxScreen(resId = R.drawable.menu, description = "menu")
            Box(
                modifier = Modifier
                    .border(3.dp, Pink40)
                    .background(Color.White)
                    //.fillMaxWidth()
                    //.size(40.dp)
                    .width(330.dp)
                    .height(30.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(10.dp)), contentAlignment = Alignment.Center
            ) {

                Row {
                    Text(text = search, fontSize = 25.sp)
                    TextField(value = search, onValueChange = { search = it },
                        placeholder = { Text(text = "Search") },
                        label = { Text(text = "Search") })
                    boxScreen(resId = R.drawable.searc, description = "search")
                }

            }
        }

        Spacer(modifier = Modifier.height(10.dp))
       Box(
            modifier = Modifier
                .background(PurpleGrey40)
                .border(3.dp, Color.White)
                .padding(20.dp)
                .height(150.dp)
                .width(330.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        {
            Spacer(modifier = Modifier.height(5.dp))
           LazyRow{
               items(tur){tur->
                   Card(modifier= Modifier
                       .border(3.dp, Color.Black)
                       .height(100.dp)
                       .width(100.dp)
                       .clip(RoundedCornerShape(20.dp))
                       .background(PurpleGrey40)){
                       Column(modifier=Modifier
                           .fillMaxSize()
                           ,verticalArrangement = Arrangement.Center
                           ,horizontalAlignment = Alignment.CenterHorizontally
                       ){
                           Text(text= tur)
                       }
                   }

               }
           }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .background(PurpleGrey40)
                .border(3.dp, Color.White)
                .padding(20.dp)
                .height(50.dp)
                .width(330.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        {
            Spacer(modifier = Modifier.height(5.dp))
            LazyRow{
                items(tur){tur->
                    Card(modifier= Modifier
                        .border(3.dp, Color.Black)
                        .height(100.dp)
                        .width(100.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(PurpleGrey40)){
                        Column(modifier=Modifier
                            .fillMaxSize()
                            ,verticalArrangement = Arrangement.Center
                            ,horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Text(text= tur)
                        }
                    }

                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .background(PurpleGrey40)
                .border(3.dp, Color.White)
                .padding(20.dp)
                .height(50.dp)
                .width(330.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        {
            Spacer(modifier = Modifier.height(5.dp))
            LazyRow{
                items(tur){tur->
                    Card(modifier= Modifier
                        .border(3.dp, Color.Black)
                        .height(100.dp)
                        .width(100.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(PurpleGrey40)){
                        Column(modifier=Modifier
                            .fillMaxSize()
                            ,verticalArrangement = Arrangement.Center
                            ,horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Text(text= tur)
                        }
                    }

                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .border(3.dp, Color.White)
                .background(PurpleGrey40)
                .padding(20.dp)
                .height(150.dp)
                .width(330.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        {
            Spacer(modifier = Modifier.height(5.dp))
            LazyRow{
                items(tur){tur->
                    Card(modifier= Modifier
                        .border(3.dp, Color.Black)
                        .height(100.dp)
                        .width(100.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(PurpleGrey40)){
                        Column(modifier=Modifier
                            .fillMaxSize()
                            ,verticalArrangement = Arrangement.Center
                            ,horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Text(text= tur)
                        }
                    }

                }
            }
        }
        Spacer(modifier = Modifier.height(900.dp))
    }
}

@Composable
fun  boxScreen(
    resId: Int,
    description: String,
    ıconColor: Color?= Black,
    bColor: Color?= Pink80,
    size: Int?=30,
    ıconSize: Int=40) {
    Box(
        modifier = Modifier
            .size(size!!.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(bColor!!), contentAlignment = Alignment.Center
    )
    {
        Icon(
            painter = painterResource(id = resId),
            contentDescription = description,
            modifier = Modifier.size(ıconSize.dp),
            tint = ıconColor!!
        )
    }





          {
            NavHost(navController = navControl , startDestination = Screen.HomeScreen.route){
                composable(Screen.HomeScreen.route){ HomeScreen()}
                composable(Screen.Profile.route){ Profile() }
                composable(Screen.logOut.route){ logOut() }
            }

        }
    */

