package edu.pwr.jakubwiraszka.moviesdisplay.utils

data class Movie(
    val id: String,
    val title: String,
    val description: String,
    val duration: Int,
    val release: String,
    val actors: List<Pair<String, String>>,
    val scenes: List<Int>,
    val icon: Int,
    val videos: List<Int>
)