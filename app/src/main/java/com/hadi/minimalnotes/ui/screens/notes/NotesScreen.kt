package com.hadi.minimalnotes.ui.screens.notes

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hadi.minimalnotes.ui.components.ImageButton
import com.hadi.minimalnotes.ui.components.NoteCard
import com.hadi.minimalnotes.ui.navigation.Screen
import com.hadi.minimalnotes.ui.theme.*
import com.hadi.minimalnotes.util.StaggeredVerticalGrid
import com.hadi.minimalnotes.util.Utils.getColorIntervals
import notedb.NoteEntity

@Composable
fun NotesScreen(
    navController: NavController,
    viewModel:NoteViewModel = hiltViewModel()
) {

    val notes = viewModel.notes.collectAsState(
        initial = emptyList()
    ).value

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 12.dp,
                        vertical = 12.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Notes",
                    color = white,
                    style = MaterialTheme.typography.h4
                )

                ImageButton(
                    icon = Icons.Outlined.Search,
                    onClick = {

                    }
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {


                StaggeredVerticalGrid(
                    maxColumnWidth = 220.dp,
                    modifier = Modifier.padding(8.dp)
                ) {

                    notes.forEachIndexed { index, note ->
                        val color = getColorIntervals(index,notes.size)
                        NoteCard(
                            noteEntity = note,
                            cardColor = color
                        ) {

                            navController.navigate(Screen.ViewNoteScreen.route+"/${note.id}")

                        }
                    }
                }
            }

        }
        ImageButton(
            modifier = Modifier.
                align(Alignment.BottomEnd)
                .padding(12.dp),
            size = 64.dp,
            icon = Icons.Outlined.Add,
            onClick = {
                navController.navigate(Screen.AddNoteScreen.route)
            }
        )
    }
}