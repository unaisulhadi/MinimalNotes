package com.hadi.minimalnotes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hadi.minimalnotes.ui.theme.Helvetica
import com.hadi.minimalnotes.ui.theme.black
import com.hadi.minimalnotes.ui.theme.card1
import notedb.NoteEntity

@Composable
fun NoteCard(
    modifier: Modifier = Modifier,
    noteEntity: NoteEntity,
    cardColor:Color,
    onNoteClick : (NoteEntity) -> Unit = {}
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
            .background(
                cardColor,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable(onClick = { onNoteClick(noteEntity) }),
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {

            Text(
                text = noteEntity.noteTitle,
                style = MaterialTheme.typography.subtitle1,
                fontSize = 20.sp,
                maxLines = 6,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = noteEntity.createdAt,
                style = MaterialTheme.typography.subtitle1,
                color = black.copy(alpha = 0.4f),
                fontSize = 14.sp
            )
        }

    }


}