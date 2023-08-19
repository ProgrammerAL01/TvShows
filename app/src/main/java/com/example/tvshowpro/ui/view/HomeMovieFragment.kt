package com.example.tvshowpro.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tvshowpro.R
import com.example.tvshowpro.data.event.ItemTvShowClickListener
import com.example.tvshowpro.data.model.TvShowsItem
import com.example.tvshowpro.databinding.FragmentHomeMovieBinding
import com.example.tvshowpro.ui.adapter.TvShowsAdapter
import com.example.tvshowpro.ui.viewmodel.TvShowsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeMovieFragment : Fragment(), ItemTvShowClickListener {
    private lateinit var binding: FragmentHomeMovieBinding
    private val viewModel:TvShowsViewModel by viewModels()
    private lateinit var tvShowsAdapter:TvShowsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= FragmentHomeMovieBinding.inflate(layoutInflater)
        bindViews()
        return binding.root
    }

    private fun bindViews() {
        tvShowsAdapter = TvShowsAdapter(this)
        viewModel.responseTvShows.observe(viewLifecycleOwner) { listTvShow ->
            tvShowsAdapter.tvShowsModel = listTvShow
        }
        binding.recycler.apply {
            adapter = tvShowsAdapter
            layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
        }
    }
    override fun onItemClick(model: TvShowsItem) {
        val bundle = Bundle().apply {
            putString("IMAGE_BACK", model.image.medium)
            putString("RATE", model.rating.average.toString())
            putString("TIME", model.averageRuntime.toString())
            putString("DATE", model.premiered)
            putString("URL", model.url)
            putString("LANGUAGE", model.language)
            putString("summary",model.summary)
            putString("Genres",model.genres.toString())
        }
        findNavController().navigate(R.id.action_homeMovieFragment_to_detailsMovieFragment, bundle)
    }
}

