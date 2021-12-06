package com.hadi.minimalnotes.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hadi.minimalnotes.R

val Helvetica = FontFamily(
    Font(R.font.hnl),
    Font(R.font.hnm, FontWeight.W500),
    Font(R.font.hnb, FontWeight.Bold)
)

// Set of Material typography styles to start with
val typography = Typography(
    h1 = TextStyle(
        fontFamily = Helvetica,
        fontWeight = FontWeight.W600,
        fontSize = 56.sp
    ),
    h2 = TextStyle(
        fontFamily = Helvetica,
        fontWeight = FontWeight.W600,
        fontSize = 48.sp
    ),
    h3 = TextStyle(
        fontFamily = Helvetica,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    h4 = TextStyle(
        fontFamily = Helvetica,
        fontWeight = FontWeight.W600,
        fontSize = 30.sp
    ),
    h5 = TextStyle(
        fontFamily = Helvetica,
        fontWeight = FontWeight.W400,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = Helvetica,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Helvetica,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
        lineHeight = 26.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = Helvetica,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = Helvetica,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    body2 = TextStyle(
        fontFamily = Helvetica,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    button = TextStyle(
        fontFamily = Helvetica,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        letterSpacing = 4.sp
    ),
    caption = TextStyle(
        fontFamily = Helvetica,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = Helvetica,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    )
)