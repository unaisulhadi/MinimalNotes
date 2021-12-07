package com.hadi.minimalnotes.ui.screens.search_note

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hadi.minimalnotes.ui.components.ImageButton
import com.hadi.minimalnotes.ui.components.NoteCard
import com.hadi.minimalnotes.ui.components.SearchTextField
import com.hadi.minimalnotes.ui.navigation.Screen
import com.hadi.minimalnotes.util.StaggeredVerticalGrid
import com.hadi.minimalnotes.util.Utils


@Composable
fun SearchNoteScreen(
    navController: NavController,
    viewModel: SearchNoteViewModel = hiltViewModel()
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

            ImageButton(
                modifier = Modifier.padding(12.dp),
                icon = Icons.Default.KeyboardArrowLeft,
            ) {
                navController.navigateUp()
            }

            SearchTextField(
                value = viewModel.searchText,
                onValueChange = viewModel::setSearchField,
                placeHolder = "Search Note..",
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {


                StaggeredVerticalGrid(
                    maxColumnWidth = 220.dp,
                    modifier = Modifier.padding(8.dp)
                ) {

                    Log.d("NOTES==",notes.toString())

                    notes.forEachIndexed { index, note ->
                        val color = Utils.getColorIntervals(index, notes.size)
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

}
