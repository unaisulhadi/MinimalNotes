package com.hadi.minimalnotes.ui.screens.add_note


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hadi.minimalnotes.ui.components.ImageButton
import com.hadi.minimalnotes.ui.components.NoteTextField
import com.hadi.minimalnotes.ui.theme.buttonColor
import com.hadi.minimalnotes.ui.theme.white

@Composable
fun AddNoteScreen(
    navController: NavController,
    viewModel: AddNoteViewModel = hiltViewModel()
) {

    val focusManager = LocalFocusManager.current


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            ImageButton(
                icon = Icons.Default.KeyboardArrowLeft
            ) {
                navController.navigateUp()
            }

            Box(
                modifier = Modifier
                    .background(
                        buttonColor,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .height(40.dp)
                    .width(80.dp)
                    .clickable(
                        onClick = {
                            viewModel.onSaveNote()
                            if (viewModel.noteTitleField.isNotBlank()) {
                                navController.navigateUp()
                            }
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "Save",
                    color = white,
                    style = MaterialTheme.typography.button
                )

            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        NoteTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = viewModel.noteTitleField,
            onValueChange = viewModel::onTitleChange,
            imeAction = ImeAction.Next,
            placeHolderTitle = "Note Title",
            onNextClick = { focusManager.moveFocus(FocusDirection.Down) }
        )
        Spacer(modifier = Modifier.height(4.dp))
        NoteTextField(
            modifier = Modifier
                .fillMaxSize(),
            value = viewModel.noteContentField,
            onValueChange = viewModel::onContentChange,
            imeAction = ImeAction.None,
            placeHolderTitle = "Note Content",
        )
        Spacer(modifier = Modifier.height(10.dp))

    }


}