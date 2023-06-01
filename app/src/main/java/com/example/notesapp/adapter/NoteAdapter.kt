package com.example.notesapp.adapter


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.data.entity.Note
import com.example.notesapp.databinding.FragmentItemBinding
import java.text.SimpleDateFormat


class NoteAdapter(    private val mNotes :List<Note>,
                      private val listener : OnNoteClickListener
): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    interface OnNoteClickListener{
        fun onNoteClick(note:Note)
        fun onNoteLongClick(note:Note)
    }


    inner class ViewHolder(
        private val binding: FragmentItemBinding
    ): RecyclerView.ViewHolder(binding.root){

        init{
            binding.apply{
                root.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION){
                        val note = mNotes[position]
                        listener.onNoteClick(note)
                    }
                }
                root.setOnLongClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION){
                        val note = mNotes[position]
                        listener.onNoteLongClick(note)
                    }
                    true
                }
            }
        }

        //@SuppressLint("SimpleDateFormat")
        fun bind(note:Note){
            //ui
            binding.apply{
                titleNote.text = note.title
                contentNote.text = note.content
                val formatter = SimpleDateFormat( "dd/MM/yyy" )
                dateNote.text = formatter.format(note.date)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val binding = FragmentItemBinding.inflate(LayoutInflater.from
            (parent.context), parent, false
        )
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       with(mNotes[position]){
           holder.bind(this)
       }
    }

    override fun getItemCount(): Int {
        return mNotes.size
    }

}