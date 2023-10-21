package com.example.animetrack.view

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.animetrack.R
import com.example.animetrack.model.Anime
import com.example.animetrack.model.AnimeListFragment

class AnimeListActivity: AppCompatActivity(), AnimeListFragment.OnAnimeClickListener {

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
    }
    override fun onAnimeClick(Anime: Anime) {
        TODO("Not yet implemented")
    }
}