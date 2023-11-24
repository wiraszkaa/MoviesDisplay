package edu.pwr.jakubwiraszka.moviesdisplay.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Scenes(scenes: List<Int>) {
    var selectedIndex by remember { mutableStateOf(-1) }
    if (selectedIndex == -1)
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(8.dp),
        ) {
            items(scenes.size) { index ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.height(100.dp)
                ) {
                    Image(
                        painter = painterResource(id = scenes[index]),
                        contentDescription = "alt",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxSize()
                            .clip(RoundedCornerShape(16.dp))
                            .clickable { selectedIndex = index }

                    )
                }
            }
        }
    else
        Image(
            painter = painterResource(id = scenes[selectedIndex]),
            contentDescription = "alt",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(4.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp))
                .clickable { selectedIndex = -1 }
        )

}