package com.o3interfaces.composeapp.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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