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
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hadi.minimalnotes.ui.components.ImageButton
import com.hadi.minimalnotes.ui.components.NoteCard
import com.hadi.minimalnotes.ui.theme.white
import com.hadi.minimalnotes.util.StaggeredVerticalGrid

@Composable
fun NotesScreen(
    navController: NavController,
) {

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 12.dp,
                        vertical = 8.dp
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

//            LazyVerticalGrid(
//                cells = GridCells.Fixed(2)
//            ) {
//                items(20) {
//                    NoteCard()
//                }
//            }

            StaggeredVerticalGrid(
                maxColumnWidth = 220.dp,
                modifier = Modifier.padding(8.dp)
            ) {
                (0..20).forEach { course ->
                    NoteCard()
                }
            }

        }
    }
}