package com.softradix.jetpackcomposedemo.harency

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softradix.jetpackcomposedemo.R
import com.softradix.jetpackcomposedemo.ui.theme.Purple500

@Preview(showBackground = true)
@Composable
fun CountryCodeScreen() {
    var search by remember {
        mutableStateOf(TextFieldValue(""))
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier
                    .padding()
                    .padding(16.dp),
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null
            )
            Text(
                text = "Country Codes",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.SemiBold),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            )
        }

        TextField(value = search, onValueChange = {
            search = it
        }, modifier = Modifier.padding(horizontal = 20.dp)
            .background(color = Color.White)
            .fillMaxWidth()
            .border(shape = RoundedCornerShape(16.dp),
                width = 1.dp,
                color = Purple500
        ), trailingIcon = {
                Image(
                    painter =
                    painterResource(id = R.drawable.ic_search),
                    contentDescription = null
                )
            })
    }
}