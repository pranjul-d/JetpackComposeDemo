package com.softradix.jetpackcomposedemo.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.softradix.jetpackcomposedemo.R

// Set of Material typography styles to start with
val Typography by lazy {
    Typography(
        body1 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        button = TextStyle(
            fontFamily = fonts,
            fontSize = 14.sp
        ),
        caption = TextStyle(
            fontFamily =fonts ,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
    )
}




val fonts = FontFamily(
//    Font(resId = R.font.mulish_regular, weight = FontWeight.Normal)
    Font(R.font.mulish_regular,
        weight = FontWeight.Normal)
)