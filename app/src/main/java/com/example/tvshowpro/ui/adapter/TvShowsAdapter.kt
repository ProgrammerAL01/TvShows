package com.example.tvshowpro.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.tvshowpro.data.event.ItemTvShowClickListener
import com.example.tvshowpro.data.model.TvShowsItem
import com.example.tvshowpro.databinding.MovieItemBinding


class TvShowsAdapter(private val listener:ItemTvShowClickListener) : RecyclerView.Adapter<TvShowsViewHolder>() {
    private val diffCallBack = object : DiffUtil.ItemCallback<TvShowsItem>() {
        override fun areItemsTheSame(oldItem: TvShowsItem, newItem: TvShowsItem): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: TvShowsItem, newItem: TvShowsItem): Boolean =
            oldItem == newItem

    }
    private val differ = AsyncListDiffer(this, diffCallBack)
    var tvShowsModel: List<TvShowsItem>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder =
        TvShowsViewHolder(
            MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int {
        return tvShowsModel.size
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        holder.bindViews(tvShowsModel[position],listener)
    }
}