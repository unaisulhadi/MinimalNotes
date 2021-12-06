package com.hadi.minimalnotes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hadi.minimalnotes.ui.theme.Helvetica
import com.hadi.minimalnotes.ui.theme.black
import com.hadi.minimalnotes.ui.theme.card1

@Preview
@Composable
fun NoteCard(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
            .background(
                card1,
                shape = RoundedCornerShape(8.dp)
            ),
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(
                text = "Note title goes here",
                style = MaterialTheme.typography.caption,
                fontWeight = FontWeight.W500,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "15 August, 2020",
                style = MaterialTheme.typography.caption,
                color = black.copy(alpha = 0.5f),
                fontSize = 12.sp
            )
        }

    }


}