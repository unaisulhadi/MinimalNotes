package com.hadi.minimalnotes.ui.screens.add_note


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hadi.minimalnotes.R
import com.hadi.minimalnotes.ui.components.ImageButton
import com.hadi.minimalnotes.ui.theme.buttonColor
import com.hadi.minimalnotes.ui.theme.white

@Composable
fun AddNoteScreen(
    navController: NavController
) {

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
            )

            Box(
                modifier = Modifier
                    .background(
                        buttonColor,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .height(40.dp)
                    .width(80.dp),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "Save",
                    color = white,
                    style = MaterialTheme.typography.button
                )

            }

        }

    }


}