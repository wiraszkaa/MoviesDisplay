package edu.pwr.jakubwiraszka.moviesdisplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import edu.pwr.jakubwiraszka.moviesdisplay.composables.Actors
import edu.pwr.jakubwiraszka.moviesdisplay.composables.MovieDescription
import edu.pwr.jakubwiraszka.moviesdisplay.composables.Scenes
import edu.pwr.jakubwiraszka.moviesdisplay.ui.theme.MoviesDisplayTheme
import edu.pwr.jakubwiraszka.moviesdisplay.utils.getMovie

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
                    var isScenes by remember { mutableStateOf(true) }
                    Column(modifier = Modifier.fillMaxSize()) {
                        MovieDescription(movie = movie)

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(8.dp).fillMaxWidth()
                        ) {
                            Button(
                                onClick = { isScenes = true },
                                enabled = !isScenes,
                            ) {
                                Text(text = "Scenes")
                            }

                            Button(
                                onClick = { isScenes = false },
                                enabled = isScenes,
                            ) {
                                Text(text = "Actors")
                            }
                        }

                        if (isScenes) Scenes(scenes = movie.scenes) else Actors(actors = movie.actors)
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