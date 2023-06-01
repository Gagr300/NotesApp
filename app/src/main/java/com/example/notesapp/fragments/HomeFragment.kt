/*
package com.example.notesapp.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.notesapp.HomeActivity
import com.example.notesapp.MainActivity
import com.example.notesapp.R
import com.example.notesapp.adapter.NoteAdapter
import com.example.notesapp.databinding.FragmentHomeBinding

import com.example.notesapp.viewmodel.NoteViewModel

class HomeFragment : Fragment(R.layout.fragment_home){

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(
            inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        /*
        noteViewModel = (activity as HomeActivity).noteViewModel
        setUpRecyclerView()
        */

        binding.fabAddNote.setOnClickListener {
            mView ->
            mView.findNavController().
            navigate(R.id.action_homeFragment_to_newNoteFragment)
        }
    }

    private fun setUpRecyclerView() {
        noteAdapter = NoteAdapter()

        binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(
                2,
                StaggeredGridLayoutManager.VERTICAL
            )
            setHasFixedSize(true)
            adapter = noteAdapter
        }

        activity?.let {
            noteViewModel.getAllNotes().observe(viewLifecycleOwner,
                Observer{ note ->
                noteAdapter.differ.submitList(note)
                updateUI(note)
            })
        }

    }

    private fun updateUI(note: List<Note>) {
        if (note.isNotEmpty()) {
            binding.recyclerView.visibility = View.VISIBLE
            binding.tvNoNotesAvailable.visibility = View.GONE
        } else {
            binding.recyclerView.visibility = View.GONE
            binding.tvNoNotesAvailable.visibility = View.VISIBLE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        //menu.clear()
        inflater.inflate(R.menu.home_menu, menu)

    }




    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
*/