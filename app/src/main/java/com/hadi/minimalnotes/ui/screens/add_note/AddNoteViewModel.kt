package com.hadi.minimalnotes.ui.screens.add_note

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hadi.minimalnotes.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    var noteTitleField by mutableStateOf("")
        private set

    var noteContentField by mutableStateOf("")
        private set

    fun onSaveNote() {
        if (noteTitleField.isBlank()) {
            return
        }

        viewModelScope.launch {
            repository.insertNote(noteTitleField, noteContentField, getCreationTime())
        }
    }

    fun onTitleChange(value:String){
        this.noteTitleField = value
    }

    fun onContentChange(value:String){
        this.noteContentField = value
    }

    private fun getCreationTime() : String{
        val date = Date()
        val sdf = SimpleDateFormat("dd MMMM, yyyy", Locale.getDefault())
        return sdf.format(date)
    }

}