package edu.pwr.jakubwiraszka.moviesdisplay

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import edu.pwr.jakubwiraszka.moviesdisplay.composables.Movies
import edu.pwr.jakubwiraszka.moviesdisplay.ui.theme.MoviesDisplayTheme
import edu.pwr.jakubwiraszka.moviesdisplay.utils.DATA

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesDisplayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Movies(movies = DATA.MOVIES, onClick = { movie -> onClick(movie, this) })
                }
            }
        }
    }

    private fun onClick(movie: String, context: Context) {
        val intent = Intent(context, MovieDescriptionActivity::class.java)
        intent.putExtra("MOVIE", movie)
        startActivity(intent)
    }
}