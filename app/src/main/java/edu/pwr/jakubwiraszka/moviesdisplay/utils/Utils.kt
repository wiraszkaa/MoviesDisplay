package edu.pwr.jakubwiraszka.moviesdisplay.utils

fun durationToString(duration: Int): String {
    val hours = duration / 60
    return when(val minutes = duration - hours * 60) {
        0 -> "$hours h"
        else -> "${hours}h ${minutes}min"
    }
}