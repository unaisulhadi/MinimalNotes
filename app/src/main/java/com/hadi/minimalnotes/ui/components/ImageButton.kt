package com.hadi.minimalnotes.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hadi.minimalnotes.ui.theme.buttonColor
import com.hadi.minimalnotes.ui.theme.white

@Composable
fun ImageButton(
    color: Color = buttonColor,
    iconColor:Color = white,
    icon: ImageVector,
    size: Dp = 40.dp,
    iconSize:Dp = 28.dp,
    onClick: () -> Unit = {}
) {

    Box(
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .background(
                    color,
                    shape = RoundedCornerShape(8.dp)
                )
                .size(size)
                .clickable(onClick = onClick)

        )
        Icon(
            imageVector = icon,
            tint= iconColor,
            contentDescription = null,
            modifier = Modifier.padding(4.dp)
                .size(iconSize)
        )
    }

}