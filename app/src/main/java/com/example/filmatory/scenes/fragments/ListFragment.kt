package com.example.filmatory.scenes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmatory.R
import com.example.filmatory.api.data.user.UserLists
import com.example.filmatory.utils.items.ListItem
import com.example.filmatory.utils.adapters.ListsAdapter

class ListFragment : Fragment(R.layout.fragment_list) {
    private val listsArrayList: MutableList<ListItem> = ArrayList()
    private lateinit var listsAdapter : ListsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val createListBtn : Button = view.findViewById(R.id.newListBtn)
        val recyclerView : RecyclerView = view.findViewById(R.id.userlists_rv)
        listsAdapter = ListsAdapter(listsArrayList, requireActivity())
        recyclerView.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = listsAdapter
        createListBtn.setOnClickListener {
            val listName : String = view.findViewById<TextView>(R.id.accinfoNewListTextField).text.toString()
            listsArrayList.add(ListItem(listName, "Dybe", "http://placeimg.com/640/480/any", "12", "14", "1231"))
        }
    }

    fun showUserLists(userLists: UserLists){
        activity?.runOnUiThread(Runnable {
            if(isAdded){
                for(item in userLists){
                    listsArrayList.add(ListItem(item.listname, item.listUserId, "http://placeimg.com/640/480/any", "55", "", item.listId))
                }
                listsAdapter.notifyDataSetChanged()
            } else {
                println("Could not retrieve user lists, not attached to activity")
            }
        })
    }
}