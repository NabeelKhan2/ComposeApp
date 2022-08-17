package com.o3interfaces.composeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.o3interfaces.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    LoginPage()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginPage()
}

@Composable
fun LoginPage() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            Brush.verticalGradient(
                colors = listOf(
                    Color.Unspecified,
                    Color.Cyan
                )
            )
        )
        .padding(20.dp)) {
        NavigationButton(modifier = Modifier.align(Alignment.BottomCenter))
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Login", style = TextStyle(
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive
        ))

        Spacer(modifier = Modifier.height(20.dp))
        LoginTextField()

        Spacer(modifier = Modifier.height(20.dp))
        LoginTextField()

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Forgot password?", style = TextStyle(
            fontSize = 15.sp,
            fontFamily = FontFamily.Default
        ))
    }
}

@SuppressLint("ModifierParameter")
@Composable
fun NavigationButton(
    btnText: String = "Sign in",
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ) {
        Text(
            text = btnText,
            color = Color.White,
            fontSize = 14.sp
        )
    }
}

@Composable
fun LoginTextField() {
    val state = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Black
        ),
        singleLine = true,
        label = { Text(text = "Username", color = Color.Black) },
        value = state.value,
        onValueChange = { state.value = it })
}