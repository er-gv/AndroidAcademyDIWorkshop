package com.academy.di.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.academy.db.model.Movie
import com.academy.di.R
import com.academy.di.ui.navigation.NavigationViewModel

class HomeAdapter(private val viewModel: NavigationViewModel) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var data = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieHolder(v, viewModel)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MovieHolder).onBindViewHolder(data[position])
    }

    override fun getItemCount() = data.size

    fun setItems(items: List<Movie>) {
        data = items
        notifyDataSetChanged()
    }
}