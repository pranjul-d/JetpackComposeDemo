package com.softradix.jetpackcomposedemo.harency

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.softradix.jetpackcomposedemo.R
import com.softradix.jetpackcomposedemo.ui.theme.Purple500
import com.softradix.jetpackcomposedemo.utils.DrawableWrapper

@Composable
fun HarencyLoginScreen(navController: NavController) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (textConstraints, cardView, bottomConstraints) = createRefs()
        Column(modifier = Modifier
            .padding(horizontal = 10.dp)
            .padding(top = 15.dp)
            .constrainAs(textConstraints) {

            }) {
            Text(
                stringResource(R.string.sign_in),
                style = TextStyle(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text(stringResource(R.string.sign_in_to_continue))
        }
        Box(modifier = Modifier.constrainAs(cardView) {
            top.linkTo(textConstraints.bottom)
        }) { LoginCardView(navController) }

        Box(modifier = Modifier.constrainAs(bottomConstraints) {
            bottom.linkTo(parent.bottom)
        }) {
            Image(
                painter = painterResource(id = R.drawable.ic_wave),

                contentDescription = null, modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Image(
                painter = painterResource(id = R.drawable.ic_wave2),
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth,
                contentDescription = null
            )
        }
    }
}

@Composable
fun LoginCardView(navController: NavController) {
    var phoneNumber by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var password by remember {
        mutableStateOf(TextFieldValue(""))
    }

    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(0.dp)
            .padding(10.dp)
    ) {
        Column(modifier = Modifier.padding(vertical = 26.dp)) {


            Box {
                TextField(
                    value = phoneNumber,
                    onValueChange = {
                        phoneNumber = it
                    },
                    leadingIcon = {
                        Purple500
                    },
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth(),
                    placeholder = { Text("Phone Number") },

                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    keyboardActions = KeyboardActions(),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                    ),
                )

                DrawableWrapper(drawableEnd = R.drawable.ic_arrow_down) {
                    Text(
                        text = "+999",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Black
                        ),
                        modifier = Modifier
                            .padding(
                                top = 14.dp,
                                bottom = 14.dp,
                                start = 20.dp,
                            )
                            .clickable {


                            },
                    )
                }


            }
            TextField(
                value = password,
                onValueChange = {
                    password = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .padding(
                        bottom = 10.dp,
                        start = 20.dp,
                        end = 20.dp
                    ),
                placeholder = { Text("Password") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White
                )
            )
            Text(
                "Forgot password?",
                style = TextStyle(
                    color = Purple500,
                    textAlign = TextAlign.End
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        end = 15.dp,
                        bottom = 10.dp
                    )
            )

            Button(
                onClick = {}, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 15.dp)
                    .height(42.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(R.color.mainBgColor)
                ),
                shape = RoundedCornerShape(70)
            ) {
                Text(
                    stringResource(R.string.sign_in),
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }

//            Divider
            DividerView()
            SocialLoginButtons()
        }
    }

}