package com.example.animetrack.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animetrack.databinding.AnimeItemListBinding
import com.example.animetrack.model.Anime
class AnimeItemListAdapter(
    private val Animes: List<Anime>,
    private val onClick: (Anime: Anime) -> Unit,
    private val onLongClick: (title: Anime) -> Unit
) : RecyclerView.Adapter<AnimeItemListAdapter.AnimeViewHolder>() {

    class AnimeViewHolder(
        private val binding: AnimeItemListBinding,
        private val onClick: (Anime: Anime) -> Unit,
        private val onLongClick: (title: Anime) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(Anime: Anime, totalItems: Int) {
            with(binding) {
                tvTitle.text = Anime.title
                tvYear.text = Anime.year
              //  tvSeasons.text = "${Anime.seasons} seasons"
                itemImg.setImageResource(Anime.image)
                clItem.setOnClickListener {
                    onClick(Anime)
                }
                clItem.setOnLongClickListener {
                    onLongClick(Anime)
                    true
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val binding = AnimeItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(binding, onClick, onLongClick)
    }

    override fun getItemCount() = Animes.size

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(Animes[position], Animes.size)
    }

}