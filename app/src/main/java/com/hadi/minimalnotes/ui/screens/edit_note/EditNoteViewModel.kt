package com.hadi.minimalnotes.ui.screens.edit_note

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
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class EditNoteViewModel @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var noteId: Long? = null
        private set

    var noteTitleField by mutableStateOf("")
        private set

    var noteContentField by mutableStateOf("")
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
                noteTitleField = note?.noteTitle ?: ""
                noteContentField = note?.noteContent ?: ""
            }
        }
    }

    fun onSaveNote() {
        if (noteTitleField.isBlank()) {
            return
        }

        viewModelScope.launch {
            repository.insertNote(noteTitleField, noteContentField, getCreationTime(),noteId)
        }
    }

    fun onTitleChange(value: String) {
        this.noteTitleField = value
    }

    fun onContentChange(value: String) {
        this.noteContentField = value
    }

    private fun getCreationTime(): String {
        val date = Date()
        val sdf = SimpleDateFormat("dd MMMM, yyyy", Locale.getDefault())
        return sdf.format(date)
    }

}