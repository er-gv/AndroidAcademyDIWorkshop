package com.academy.ui_favorites

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.academy.ui_favorites.binding.FragmentBinding
import com.academy.ui_favorites.databinding.FragmentFavoritesBinding
import com.academy.ui_favorites.di.Dependencies
import com.academy.ui_favorites.recycler.FavoritesAdapter

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    private val viewModel: FavoritesViewModel by viewModels()
    private val binding by FragmentBinding(FragmentFavoritesBinding::bind)

    private var favoritesAdapter: FavoritesAdapter? = null
    private var gridLayoutManager: GridLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Dependencies.appContext = requireContext().applicationContext
        setRecyclerView()
        observeViewModel()
    }

    private fun setRecyclerView() {
        Log.w("Academy", "setRecyclerView")
        binding.homeRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 2).apply { gridLayoutManager = this }
            adapter = FavoritesAdapter().apply { favoritesAdapter = this }
        }
    }

    private fun observeViewModel() {
        viewModel.getMovies().observe(viewLifecycleOwner) {
            favoritesAdapter?.setItems(it)
        }
    }

}