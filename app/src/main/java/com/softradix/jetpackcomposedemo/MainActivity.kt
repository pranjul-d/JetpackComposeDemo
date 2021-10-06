package com.softradix.jetpackcomposedemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDecoration.Companion.LineThrough
import androidx.compose.ui.text.style.TextDecoration.Companion.Underline
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softradix.jetpackcomposedemo.data.Posts
import com.softradix.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme
import com.softradix.jetpackcomposedemo.ui.theme.Purple200
import com.softradix.jetpackcomposedemo.ui.theme.Shapes
import com.softradix.jetpackcomposedemo.ui.theme.Teal200
import com.softradix.jetpackcomposedemo.viewModel.PostsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: PostsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getPostsData()

        setContent {
            JetpackComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android",viewModel = viewModel)
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        JetpackComposeDemoTheme {
        Greeting("Android",viewModel = viewModel)
        }
    }
}

@Composable
fun Greeting(name: String,viewModel: PostsViewModel) {
    val context = LocalContext.current
    val listState = rememberLazyListState()

    Box(modifier = Modifier.fillMaxHeight().background(Color.Unspecified)) {

        getPostsCard(viewModel =viewModel)

        FloatingActionButton(
            onClick = {
                Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show()
            }, modifier = Modifier.align(Alignment.BottomEnd)
                .padding(20.dp)
        ) {
            Text("+", fontSize = 16.sp)
        }
//        MessageCard(SampleData.conversationSample)

    }


}


@Composable
fun getPostsCard(viewModel: PostsViewModel) {
    LazyColumn() {
        items(viewModel.postMutableLiveData) { posts->
            CardView(posts)
        }
    }

}

@Composable
fun CardView(posts: Posts) {
    val context = LocalContext.current
    val painter = painterResource(R.drawable.programmer)
    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier.padding(10.dp).clickable {
            Toast.makeText(context, "Card View Clicked!", Toast.LENGTH_SHORT).show()
        }
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(5.dp)) {
            Row {
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier.padding(10.dp).width(50.dp).height(50.dp)
                        .clip(shape = RoundedCornerShape(10))
                )
                Column {
                    Text(
                        posts.title,
                        fontSize = 24.sp
                    )
                    Text(
                        posts.body,
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 18.sp
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun MessageCard(msgs: List<Message>) {
    val brush = Brush.horizontalGradient(listOf(Purple200, Teal200))

    LazyColumn(
        modifier = Modifier
            .background(brush = brush).fillMaxWidth(),
        reverseLayout = true,
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
    ) {

        item {
            Column {
                Text(
                    text = "Hello Android!",
                )

                Text(
                    "Hello With background and font weight",
                    modifier = Modifier.padding(10.dp)
                        .background(
                            shape = Shapes.small, color = Teal200
                        ).padding(10.dp),
                    color = Color.DarkGray,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraLight
                )

                Text(
                    "Text with cursive font",
                    modifier = Modifier.padding(10.dp)
                        .background(
                            shape = Shapes.small, color = Teal200
                        ).padding(10.dp),
                    fontSize = 25.sp,
                    style = TextStyle(fontFamily = FontFamily.Cursive)
                )
                Text(
                    text = "Text with LineThrough",
                    style = TextStyle(
                        textDecoration = TextDecoration.combine(
                            listOf(LineThrough, Underline)
                        )
                    ),
                    fontWeight = FontWeight.Bold
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(color = Color.Transparent)
                        .padding(10.dp)
                ) {
                    val image: Painter =
                        painterResource(id = R.drawable.ic_baseline_stay_current_landscape_24)
                    Image(
                        painter = image, contentDescription = "",
                        modifier = Modifier
                            .background(color = Color.Red)
                            .fillMaxHeight()
                    )

                    Text(
                        "Hello With background and style",
                        modifier = Modifier.padding(10.dp)
                            .background(
                                shape = Shapes.small, color = Teal200
                            ).padding(10.dp),

                        color = Color.DarkGray,
                        fontSize = 25.sp,
                        style = TextStyle(textDirection = TextDirection.ContentOrLtr)
                    )
                }
                val fullName = remember { mutableStateOf(TextFieldValue()) }


                TextField(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
                    value = fullName.value,
                    singleLine = true,
                    onValueChange = {
                        fullName.value = it
                    },
                    label = {
                        Text("Enter you name")
                    }
                )

            }
        }
        items(msgs) { item: Message ->
            Messages(item)
        }
    }
}


@Composable
fun Messages(msg: Message) {
    // We keep track if the message is expanded or not in this
    // variable
    var isExpanded = remember { mutableStateOf(false) }

    // We toggle the isExpanded variable when we click on this Column
    Column(modifier = Modifier.clickable { isExpanded != isExpanded }) {

        Spacer(modifier = Modifier.height(4.dp))

        Surface(
            shape = MaterialTheme.shapes.medium,
            elevation = 1.dp,
        ) {
            Text(
                text = msg.body,
                modifier = Modifier.padding(all = 4.dp),
                // If the message is expanded, we display all its content
                // otherwise we only display the first line
                maxLines = if (isExpanded.value) Int.MAX_VALUE else 1,
                style = MaterialTheme.typography.body1
            )
        }
    }
}

