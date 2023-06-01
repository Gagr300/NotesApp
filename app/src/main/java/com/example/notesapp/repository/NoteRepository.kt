package com.example.notesapp.repository


import com.example.notesapp.data.entity.Note
import com.example.notesapp.db.NoteDatabase

class NoteRepository (private val db: NoteDatabase) {


    suspend fun addNote(note: Note) = db.getNoteDao().insertNote(note)
    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)
    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)

    fun getAllNotes() = db.getNoteDao().getAllNotes()

}