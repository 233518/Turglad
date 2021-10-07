package com.example.filmatory.scenes

import android.os.Bundle
import com.example.filmatory.R
import com.example.filmatory.controllers.LoginController

class LoginScene : SuperScene() {
    private lateinit var loginController: LoginController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)
        loginController = LoginController(this)

    }
}

