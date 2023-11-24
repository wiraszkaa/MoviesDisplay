package edu.pwr.jakubwiraszka.moviesdisplay.utils

import edu.pwr.jakubwiraszka.moviesdisplay.R

val mcGregor = Pair("Obi-Wan Kenobi", "Ewan McGregor")
val neeson = Pair("Qui-Gon Jinn", "Liam Neeson")
val lloyd = Pair("Anakin Skywalker", "Jake Lloyd")
val christensen = Pair("Anakin Skywalker", "Hayden Christensen")
val portman = Pair("Padmé Amidala", "Natalie Portman")
val mcDiarmid = Pair("Chancellor Palpatine", "Ian McDiarmid")
val knightley = Pair("Sabé", "Keira Knightley")
val quiGon = Pair("Qui-Gon Jinn", "Liam Neeson")
val morrison = Pair("Jango Fett", "Temuera Morrison")
val byrne = Pair("Dormé", "Rose Byrne")
val lee = Pair("Count Dooku", "Christopher Lee")
val jacson = Pair("Mace Windu", "Samuel L. Jacson")
val smits = Pair("Bail Organa", "Jimmy Smits")

object DATA {
    val MOVIES = listOf(
        Movie(
            id = "1",
            title = "Star Wars - The Phantom Menace",
            description = "Two Jedi knights embark on a mission to save the planet Naboo from an invasion by Trade Federation troops. They end up on the desert globe, where little Anakin Skywalker will help them.",
            duration = 136,
            release = "19 May 1999",
            actors = listOf(mcGregor, neeson, lloyd, portman, mcDiarmid, knightley),
            scenes = listOf(
                R.drawable.sw1_1,
                R.drawable.sw1_2,
                R.drawable.sw1_3,
                R.drawable.sw1_4,
                R.drawable.sw1_5,
                R.drawable.sw1_6,
                R.drawable.sw1_7,
                R.drawable.sw1_8
            ),
            icon = R.drawable.star_wars_1
        ),
        Movie(
            id = "2",
            title = "Star Wars - Attack of the Clones",
            description = "The democratic rule of the Republic is threatened by the vicious Count Dooku. Meanwhile, Anakin Skywalker breaks the rules of the Jedi Order and falls in love.",
            duration = 142,
            release = "16 May 2002",
            actors = listOf(christensen, mcGregor, portman, morrison, byrne, lee),
            scenes = listOf(
                R.drawable.sw2_1,
                R.drawable.sw2_2,
                R.drawable.sw2_3,
                R.drawable.sw2_4,
                R.drawable.sw2_5,
                R.drawable.sw2_6,
                R.drawable.sw2_7,
                R.drawable.sw2_8,
                R.drawable.sw2_9
            ),
            icon = R.drawable.star_wars_2
        ),
        Movie(
            id = "3",
            title = "Star Wars - Revenge of the Sith",
            description = "The Clone Wars are coming to an end, and Obi-Wan Kenobi must face his former apprentice, Anakin Skywalker, in a ferocious lightsaber duel.",
            duration = 140,
            release = "19 May 2005",
            actors = listOf(christensen, portman, mcGregor, jacson, mcDiarmid, smits),
            scenes = listOf(
                R.drawable.sw3_1,
                R.drawable.sw3_2,
                R.drawable.sw3_3,
                R.drawable.sw3_4,
                R.drawable.sw3_5,
                R.drawable.sw3_6,
                R.drawable.sw3_7
            ),
            icon = R.drawable.star_wars_3
        )
    )
}

fun getMovie(id: String): Movie {
    return DATA.MOVIES.first { it.id == id }
}