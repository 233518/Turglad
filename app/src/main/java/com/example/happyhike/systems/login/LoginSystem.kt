package com.example.happyhike.systems.login

import android.media.MediaPlayer
import android.widget.VideoView
import android.net.Uri
import android.view.View
import com.example.happyhike.R
import com.example.happyhike.logger.Logger
import com.example.happyhike.scenes.LoginScene

class LoginSystem(loginScene: LoginScene) {
    private lateinit var videoView: VideoView
    var loginScene = loginScene

    init {
        runVideo()
    }

    private fun runVideo() {
        videoView = loginScene.findViewById<View>(R.id.videoView) as VideoView
        var uri = Uri.parse("android.resource://" + loginScene.packageName + "/" + R.raw.happyhike_bg)
        videoView.setVideoURI(uri)
        videoView.start()
    }
}

