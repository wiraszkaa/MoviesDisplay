package edu.pwr.jakubwiraszka.moviesdisplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.pwr.jakubwiraszka.moviesdisplay.composables.Actors
import edu.pwr.jakubwiraszka.moviesdisplay.composables.MovieDescription
import edu.pwr.jakubwiraszka.moviesdisplay.composables.Scenes
import edu.pwr.jakubwiraszka.moviesdisplay.composables.VideoPlayer
import edu.pwr.jakubwiraszka.moviesdisplay.ui.theme.MoviesDisplayTheme
import edu.pwr.jakubwiraszka.moviesdisplay.utils.getMovie
import edu.pwr.jakubwiraszka.moviesdisplay.utils.getVideos

class MovieDescriptionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movie = getMovie(intent.getStringExtra("MOVIE")!!)
        setContent {
            MoviesDisplayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var tab by remember { mutableStateOf(0) }
                    Column(modifier = Modifier.fillMaxSize()) {
                        MovieDescription(movie = movie)

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                        ) {
                            Button(
                                onClick = { tab = 0 },
                                enabled = tab != 0,
                            ) {
                                Text(text = "Scenes")
                            }

                            Button(
                                onClick = { tab = 1 },
                                enabled = tab != 1,
                            ) {
                                Text(text = "Actors")
                            }

                            Button(
                                onClick = { tab = 2 },
                                enabled = tab != 2,
                            ) {
                                Text(text = "Trailer")
                            }
                        }
                        when (tab) {
                            0 -> Scenes(scenes = movie.scenes)
                            1 -> Actors(actors = movie.actors)
                            2 -> VideoPlayer(videoUris = getVideos(movie.id, packageName))
                        }
                    }

                    Box(
                        modifier = Modifier
                            .padding(8.dp), contentAlignment = Alignment.BottomCenter
                    ) {
                        Button(onClick = { finish() }) {
                            Text(text = "Back")
                        }
                    }
                }
            }
        }
    }
}