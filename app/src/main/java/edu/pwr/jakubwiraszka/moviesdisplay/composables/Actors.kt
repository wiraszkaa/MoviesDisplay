package edu.pwr.jakubwiraszka.moviesdisplay.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Actors(actors: List<Pair<String, String>>) {
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(actors.size) { index ->
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = actors[index].second)
                Text(text = actors[index].first, color = Color.Gray)
            }
        }
    }
}