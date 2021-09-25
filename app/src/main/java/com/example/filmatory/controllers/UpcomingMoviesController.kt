package com.example.filmatory.controllers

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmatory.R
import com.example.filmatory.scenes.UpcomingMoviesScene
import com.example.filmatory.systems.media.MediaItem
import com.example.filmatory.utils.RecyclerViewAdapter

class UpcomingMoviesController(upcomingMoviesScene: UpcomingMoviesScene) : MainController(upcomingMoviesScene) {
    val upcomingMoviesScene = upcomingMoviesScene
    init {
        val arrayList: MutableList<MediaItem> = ArrayList()
        var recyclerView: RecyclerView = upcomingMoviesScene.findViewById(R.id.recyclerView)
        arrayList.add(MediaItem("Movie 1", "Dato 1", R.drawable.movie1))
        arrayList.add(MediaItem("Movie 2", "Dato 2", R.drawable.movie2))
        arrayList.add(MediaItem("Movie 3", "Dato 3", R.drawable.movie3))
        arrayList.add(MediaItem("Movie 4", "Dato 4", R.drawable.movie4))
        arrayList.add(MediaItem("Movie 5", "Dato 5", R.drawable.movie5))
        arrayList.add(MediaItem("Movie 6", "Dato 6", R.drawable.movie6))
        arrayList.add(MediaItem("Movie 7", "Dato 7", R.drawable.movie7))
        arrayList.add(MediaItem("Movie 8", "Dato 8", R.drawable.movie8))
        arrayList.add(MediaItem("Movie 9", "Dato 9", R.drawable.movie9))
        arrayList.add(MediaItem("Movie 10", "Dato 10", R.drawable.movie10))

        val myAdapter = RecyclerViewAdapter(arrayList, upcomingMoviesScene)

        recyclerView.layoutManager = GridLayoutManager(upcomingMoviesScene, 2)
        recyclerView.adapter = myAdapter
    }
}