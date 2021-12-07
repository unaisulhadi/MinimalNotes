package com.hadi.minimalnotes.ui.screens.view_note

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hadi.minimalnotes.ui.components.ImageButton
import com.hadi.minimalnotes.ui.navigation.Screen
import com.hadi.minimalnotes.ui.theme.buttonColor
import com.hadi.minimalnotes.ui.theme.white

@Composable
fun ViewNoteScreen(
    navController: NavController,
    viewModel: ViewNoteViewModel = hiltViewModel()
) {

    viewModel.getNoteById()
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
            ){
                navController.navigate(Screen.EditNoteScreen.route+"/${note?.id}")
            }

        }

        note?.let {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = note.noteTitle,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.W500,
                color = white
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = note.createdAt,
                style = MaterialTheme.typography.body2,
                color = white.copy(0.5F)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier.verticalScroll(rememberScrollState()),
                text = note.noteContent ?: "",
                style = MaterialTheme.typography.subtitle1,
                fontSize = 18.sp,
                color = white,
            )
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