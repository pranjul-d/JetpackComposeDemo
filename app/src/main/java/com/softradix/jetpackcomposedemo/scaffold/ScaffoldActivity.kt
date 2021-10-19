package com.softradix.jetpackcomposedemo.scaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.softradix.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme
import com.softradix.jetpackcomposedemo.ui.theme.Teal200
import kotlinx.coroutines.launch

class ScaffoldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ScaffoldView()
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScaffoldView() {
    // create a scaffold state, set it to close by default
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(DrawerValue.Closed)
    )
    val coroutineScope = rememberCoroutineScope()


    Scaffold(
        // pass the scaffold state
        scaffoldState = scaffoldState,

        // When menu is clicked open the
        // drawer in coroutine scope
        topBar = {
            TopBar(onMenuClick = {
                coroutineScope.launch {
                    // to close use -> scaffoldState.drawerState.close()
                    scaffoldState.drawerState.open()
                }
            })
        },
        drawerContent = { Drawer() },
        bottomBar = { BottomBar() },
        content = { Body()},
        floatingActionButton = {
            // Create a floating action button in
            // floatingActionButton parameter of scaffold
            FloatingActionButton(

                onClick = {
                    // When clicked open Snackbar
                    coroutineScope.launch {
                        when (scaffoldState.snackbarHostState.showSnackbar(
                            // Message In the snackbar
                            message = "Snack Bar",
                            actionLabel = "Dismiss"
                        )) {
                            SnackbarResult.Dismissed -> {
                                // do something when
                                // snack bar is dismissed
                            }

                            SnackbarResult.ActionPerformed -> {
                                // when it appears
                            }
                        }
                    }
                }) {
                // Simple Text inside FAB
                Text(text = "X")
            }
        }
    )
}


@Composable
fun Body() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(text = "Body Content", color = Color(0xFF0F9D58))
    }
}

@Composable
fun BottomBar() {

    BottomAppBar(backgroundColor = Teal200) {
        Text(
            text = "Bottom Text",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().align(Alignment.CenterVertically)
        )
    }
}


@Composable
fun TopBar(onMenuClick: () -> Unit) {

    TopAppBar(title = {
        Text(text = "Scaffold||GFG", color = Color.White)
    }, navigationIcon = {
        Icon(
            imageVector = Icons.Default.Menu, contentDescription = null,
            modifier = Modifier.padding(horizontal = 10.dp).clickable {
                onMenuClick()
            }, tint = Color.White
        )
    }, backgroundColor = Teal200
    )
}

@Preview
@Composable
fun Drawer() {
    Column(modifier = Modifier.background(Color.DarkGray).fillMaxSize()) {
        // Repeat is a loop which
        // takes count as argument
        repeat(5) { item ->
            Text(text = "Item number $item", modifier = Modifier.padding(8.dp), color = Color.Black)
        }
    }
}

@Composable
fun Greeting4(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun DefaultPreview3() {
    JetpackComposeDemoTheme {
        Greeting4("Android")
    }
}