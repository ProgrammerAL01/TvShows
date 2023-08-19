package com.example.tvshowpro.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tvshowpro.databinding.FragmentDetailsMovieBinding
import com.squareup.picasso.Picasso


class DetailsMovieFragment : Fragment() {
    private lateinit var binding: FragmentDetailsMovieBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDetailsMovieBinding.inflate(inflater,container,false)
        bindViews()
        return binding.root
    }

    private fun bindViews() {
        val args = requireArguments()
        val imageBackground = args.getString("IMAGE_BACK")
        Picasso.get().load(imageBackground).into(binding.imageBack)
        Picasso.get().load(imageBackground).into(binding.image2)
        binding.txtRate.text=args.getString("RATE")
        binding.txtTime.text=args.getString("TIME")
        binding.txtLanguage.text=args.getString("LANGUAGE")
        binding.txtYear.text=args.getString("DATE")
        binding.txtSummary.text=args.getString("summary")
        binding.txtGenres.text=args.getString("Genres")
        binding.btnWeb.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = android.net.Uri.parse(args.getString("URL"))
            startActivity(i)
        }
    }
}