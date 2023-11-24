package edu.pwr.jakubwiraszka.moviesdisplay.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import edu.pwr.jakubwiraszka.moviesdisplay.utils.Movie
import edu.pwr.jakubwiraszka.moviesdisplay.utils.durationToString

@Composable
fun Movie(movie: Movie, onClick: (String) -> Unit) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.clickable { onClick(movie.id) }) {
            Image(
                painter = painterResource(id = movie.icon),
                contentDescription = "alt",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(150.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = movie.title)
                Text(text = durationToString(movie.duration))
                Text(text = "Release: ${movie.release}", color = Color.Gray)
            }
        }
        Divider()
    }
}