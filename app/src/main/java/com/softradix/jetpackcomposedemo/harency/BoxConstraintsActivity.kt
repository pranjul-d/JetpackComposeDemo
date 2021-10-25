package com.softradix.jetpackcomposedemo.harency

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Device
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.softradix.jetpackcomposedemo.R
import com.softradix.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme
import com.softradix.jetpackcomposedemo.ui.theme.Purple500
import com.softradix.jetpackcomposedemo.utils.DrawableWrapper

class BoxConstraintsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    Navigation()

//                    BoxConstraintsView()
                }
            }
        }
    }
}




@Composable
fun SocialLoginButtons() {
    val socialIconList = listOf(
        R.drawable.ic_google,
        R.drawable.ic_instagram,
        R.drawable.ic_facebook,
        R.drawable.ic_twitter_circled,
    )
    LazyRow(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        items(socialIconList) { icon ->

            Image(painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.clickable { })

        }
    }

}


@Composable
fun DividerView() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Divider(
            color = Color.Gray, modifier = Modifier
                .padding(horizontal = 20.dp)
        )
        Text(
            "Or Sign In",
            style = TextStyle(
                background = Color.White,
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .padding()
                .fillMaxWidth(.35f)
                .padding(12.dp)
                .background(Color.White)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeDemoTheme {
        Navigation()
    }
}

@Composable
private fun BoxConstraintsView() {
    BoxWithConstraints(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        val boxWithConstraintsScope = this
        val checkChangeState = remember { mutableStateOf(false) }
        Column {
            if (boxWithConstraintsScope.maxHeight >= 200.dp) {
                Text(
                    "This is only visible when the maxHeight is >= 200.dp & height is ${boxWithConstraintsScope.maxHeight}",
                    style = TextStyle(fontSize = 20.sp)
                )

                Checkbox(checked = checkChangeState.value,
                    onCheckedChange = { checkChangeState.value = it })

            } else {
                Text("minHeight: ${boxWithConstraintsScope.minHeight}, maxHeight: ${boxWithConstraintsScope.maxHeight},  minWidth: ${boxWithConstraintsScope.minWidth} maxWidth: ${boxWithConstraintsScope.maxWidth}")

            }
        }
    }
}