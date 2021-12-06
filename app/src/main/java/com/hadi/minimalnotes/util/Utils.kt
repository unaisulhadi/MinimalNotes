package com.hadi.minimalnotes.util

import androidx.compose.ui.graphics.Color
import com.hadi.minimalnotes.ui.theme.*

object Utils{


    fun getColorIntervals(index:Int, size:Int): Color {
        return when (index % size) {
            0 -> card1
            1 -> card2
            2 -> card3
            3 -> card4
            4 -> card5
            5 -> card6
            6 -> card7
            7 -> card8
            8 -> card9
            else -> card1
        }
    }

}