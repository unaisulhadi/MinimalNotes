package com.hadi.minimalnotes.ui.screens.notes

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    viewModel: NoteViewModel = hiltViewModel()
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
                        start = 12.dp,
                        end = 12.dp,
                        top = 12.dp,
                        bottom = 8.dp
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
                        navController.navigate(Screen.SearchNoteScreen.route)
                    }
                )
            }

            if (notes.isNullOrEmpty()) {

                EmptyNotes {
                    navController.navigate(Screen.AddNoteScreen.route)
                }

            } else {
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
                            val color = getColorIntervals(index, notes.size)
                            NoteCard(
                                noteEntity = note,
                                cardColor = color
                            ) {

                                navController.navigate(Screen.ViewNoteScreen.route + "/${note.id}")

                            }
                        }
                    }
                }
            }


        }
        ImageButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp),
            size = 64.dp,
            icon = Icons.Outlined.Add,
            onClick = {
                navController.navigate(Screen.AddNoteScreen.route)
            }
        )
    }
}

@Composable
fun EmptyNotes(
    onClick : () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .clickable(
                    onClick = onClick
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(75.dp)
                    .alpha(0.5F),
                painter = painterResource(id = com.hadi.minimalnotes.R.drawable.notes),
                contentDescription = "Logo",
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Hmm...Looks like it's empty here!!",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = white.copy(0.4F),
                    fontFamily = Helvetica,
                    fontSize = 16.sp
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "ADD NOTES",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = white.copy(0.4F),
                    fontFamily = Helvetica,
                    fontSize = 20.sp
                )
            )
        }

    }
}