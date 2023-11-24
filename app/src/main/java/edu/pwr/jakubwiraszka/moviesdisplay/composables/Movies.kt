package edu.pwr.jakubwiraszka.moviesdisplay.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import edu.pwr.jakubwiraszka.moviesdisplay.utils.Movie

@Composable
fun Movies(movies: List<Movie>, onClick: (String) -> Unit) {
    LazyColumn {
        items(movies.size) { index ->
            Movie(movie = movies[index], onClick = onClick)
        }
    }
}