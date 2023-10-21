package com.example.animetrack.model


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.animetrack.databinding.AnimeItemListBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animetrack.model.Anime
import com.example.animetrack.data.dummyAnimes
import com.example.animetrack.databinding.FragmentAnimeListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DiscoverFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnimeListFragment : Fragment() {

    private lateinit var listener: OnAnimeClickListener
    interface OnAnimeClickListener {
        fun onAnimeClick(Anime: Anime)
    }

    private var _binding: FragmentAnimeListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: AnimeItemListAdapter

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onAttach(context: android.content.Context) {
        super.onAttach(context)
        if (context is OnAnimeClickListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnAnimeClickListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAnimeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        adapter = AnimeItemListAdapter(Animes = dummyAnimes, onClick = {
            listener.onAnimeClick(it)
        }, onLongClick = {
            Toast.makeText(context, "long click on: "+it.title, Toast.LENGTH_SHORT).show()
        }
//            ,
//            onLongClick = {
//                Toast.makeText(context, "long click on: "+it.title, Toast.LENGTH_SHORT).Anime()
//            }
        )
        with(binding) {
            rvAnimeList.layoutManager = LinearLayoutManager(context)
            rvAnimeList.adapter = adapter
        }
        android.util.Log.d("DiscoverFragment", "setUpRecyclerView")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // avoid memory leaks
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DiscoverFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AnimeListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}