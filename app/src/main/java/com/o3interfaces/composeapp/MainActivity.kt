package com.o3interfaces.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.o3interfaces.composeapp.ui.components.LoginTextField
import com.o3interfaces.composeapp.ui.components.NavigationButton
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
        Column(
            modifier = Modifier
                .align(Alignment.Center),
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
}