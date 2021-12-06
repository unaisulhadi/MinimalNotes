package com.hadi.minimalnotes.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.hadi.minimalnotes.ui.theme.Helvetica

@Composable
fun NoteTextField(
    modifier: Modifier = Modifier,
    value:String,
    onValueChange : (String) -> Unit,
    placeHolderTitle:String,
    imeAction: ImeAction = ImeAction.Next,
    onNextClick : () -> Unit = {},
    onDoneClick : () -> Unit = {}
){
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = placeHolderTitle)
        },
        textStyle = TextStyle(
            color = Color.White,
            fontFamily = Helvetica,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp
        ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            disabledTextColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = Color.White.copy(alpha = 0.5f)
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = KeyboardType.Text,
            capitalization = KeyboardCapitalization.Sentences,
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                onNextClick()
            },
            onDone = {
                onDoneClick()
            }
        )
    )
}