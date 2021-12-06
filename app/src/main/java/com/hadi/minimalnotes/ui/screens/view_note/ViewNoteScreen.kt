package com.hadi.minimalnotes.ui.screens.view_note

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hadi.minimalnotes.ui.components.ImageButton
import com.hadi.minimalnotes.ui.theme.buttonColor
import com.hadi.minimalnotes.ui.theme.white

@Composable
fun ViewNoteScreen(
    navController: NavController,
    viewModel: ViewNoteViewModel = hiltViewModel()
) {

    val note = viewModel.note

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            ImageButton(
                icon = Icons.Default.KeyboardArrowLeft
            ) {
                navController.navigateUp()
            }

            ImageButton(
                icon = Icons.Default.Edit
            )

        }

        note?.let {
            Text(text = note.noteTitle)
            Text(text = note.createdAt)
            Text(text = note.noteContent ?: "")
        } ?: kotlin.run {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Something went wrong")
            }
        }


    }

}