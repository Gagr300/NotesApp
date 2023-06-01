
package com.example.notesapp.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.notesapp.data.dao.NoteDao
import com.example.notesapp.data.entity.Note
import com.example.notesapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteDao : NoteDao
): ViewModel()

{
    val notes = noteDao.getAllNotes()
    val notesChannel = Channel<NotesEvent>()
    val notesEvent = notesChannel.receiveAsFlow()

    // A ViewModel Scope is defined for each ViewModel in your app.
    // Any coroutine launched in this scope is automatically canceled
    // if the ViewModel is cleared.
    fun insertNote (note: Note) = viewModelScope.launch{
        noteDao.insertNote(note)
        notesChannel.send(NotesEvent.NavigateToNotesFragment)
    }

    fun updateNote (note: Note) = viewModelScope.launch{
        noteDao.updateNote(note)
        notesChannel.send(NotesEvent.NavigateToNotesFragment)
    }

    fun deleteNote (note: Note) = viewModelScope.launch{
        noteDao.deleteNote(note)
        notesChannel.send(NotesEvent.ShowUndoSnackBar(
            "Note delete successfully", note))
    }


    sealed class NotesEvent {
        data class ShowUndoSnackBar(val msg : String, val note:Note):
                NotesEvent()
        object NavigateToNotesFragment : NotesEvent()
    }
}
