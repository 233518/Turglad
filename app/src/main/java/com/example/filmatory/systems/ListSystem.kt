package com.example.filmatory.systems

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.filmatory.systems.ApiSystem.PostBaseOptions
import com.example.filmatory.errors.BaseError
import com.example.filmatory.scenes.SuperScene
import com.example.filmatory.scenes.activities.StartScene

class ListSystem(private val apiSystem: ApiSystem, private val snackbarSystem: SnackbarSystem, private val scene: AppCompatActivity) {
    fun deleteList(listId : String){
        deleteListFromDB(listId)
    }

    private fun deleteListFromDB(listId : String){
        val params: HashMap<String, String> = HashMap()
        params["listId"] = listId
        apiSystem.postListDelete(PostBaseOptions(null, null, params, ::snackBarResponse, ::onFailure))
    }

    private fun snackBarResponse(string : String?) {
        snackbarSystem.duration = 2000
        snackbarSystem.showSnackbarSuccess(string!!)
    }
    private fun onFailure(baseError: BaseError) {
        snackbarSystem.showSnackbarFailure(baseError.message, ::retry, "Home")
    }
    private fun retry() {
        val intent = Intent(scene, StartScene::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        scene.finish()
        scene.startActivity(intent)
    }
}