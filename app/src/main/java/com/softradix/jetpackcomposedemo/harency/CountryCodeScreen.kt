package com.softradix.jetpackcomposedemo.harency

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softradix.jetpackcomposedemo.R
import com.softradix.jetpackcomposedemo.data.CountriesItem
import com.softradix.jetpackcomposedemo.ui.theme.Purple500
import com.softradix.jetpackcomposedemo.utils.Utilities

@Preview(showBackground = true, device = Devices.NEXUS_5X)
@Composable
fun CountryCodeScreen() {
    val context = LocalContext.current
    val countries = remember { Utilities.generateList(context) }

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

        TextField(value = search,
            onValueChange = {
                search = it
                if (!search.text.isNullOrEmpty()) {
                    findCountry(search.text, countries)
                }

            }, modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .border(
                    shape = RoundedCornerShape(16.dp),
                    width = 1.dp,
                    color = Purple500
                ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                focusedIndicatorColor = Color.White,
            ),
            trailingIcon = {
                Image(
                    painter =
                    painterResource(id = R.drawable.ic_search),
                    contentDescription = null
                )
            })

        LazyColumn(
            modifier = Modifier.padding(5.dp),
        ) {
            items(countries) { country ->
//                val state = rememberSaveable(country) { mutableStateOf(ItemState()) }
//                key(country) {
//                }
                CountryCodeCard(country)
            }
        }
    }
}

fun findCountry(string: String, countries: ArrayList<CountriesItem>)
        : ArrayList<CountriesItem> {
    val list = arrayListOf<CountriesItem>()
    countries.forEach {
        if (string.lowercase().contains(it.name.lowercase())) {
            list.add(it)
            Log.e("TAG", "findCountry: $list")
        }
    }
    return if (list.isNotEmpty()) list else countries
}