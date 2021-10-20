package com.aleangelozi.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aleangelozi.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //Image()
                    //UserCard()
                    UserList()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current

    Surface(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Hello $name!",
            fontSize = 22.sp,
            color = colorResource(id = R.color.purple_700),
            fontFamily = FontFamily.Cursive,
            modifier = Modifier.clickable {
                Toast.makeText(context, "You clicked", Toast.LENGTH_LONG).show()
            }
        )
    }

}

@Composable
fun Image() {
    Row {
        Surface(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.ic_house),
                contentDescription = ""
            )
        }

    }
}

@Composable
fun UserCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(12.dp)
            .border(1.dp, color = Color.Gray)
            .padding(12.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_house),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(120.dp)
        )

        Column {
            Text(text = "My name is Alessandro!")
            Button(onClick = { /*TODO*/ }) {
                Text(text = "View Profile")

            }
        }


    }
}

val users = listOf(
    User(1),
    User(2),
    User(3),
    User(4),
    User(5),
    User(6),
    User(7),
    User(8),
    User(9),
    User(10)
)

@Composable
fun UserList() {
    /*Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        for (i in 1..10) {
            UserCard()
        }

    }*/

    LazyColumn {
        items(users) {
            UserCard()

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {

        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxSize()
        ) {
            //Image()
            UserCard()
        }
    }
}