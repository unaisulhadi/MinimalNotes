package com.hadi.minimalnotes.ui.screens.view_note

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hadi.minimalnotes.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import notedb.NoteEntity
import javax.inject.Inject

@HiltViewModel
class ViewNoteViewModel @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var noteId: Long? = null
        private set

    var note by mutableStateOf<NoteEntity?>(null)
        private set

    init {
        savedStateHandle.get<String>("noteId")?.let { noteId ->
            this.noteId = noteId.toLong()
            getNoteById()
        }
    }

    fun getNoteById() {
        viewModelScope.launch {
            noteId?.let {
                note = repository.getNoteById(it)
            }
        }
    }


}