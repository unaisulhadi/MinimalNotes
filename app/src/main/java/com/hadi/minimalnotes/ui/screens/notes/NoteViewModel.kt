package com.hadi.minimalnotes.ui.screens.notes

import androidx.lifecycle.ViewModel
import com.hadi.minimalnotes.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val notes = repository.getAllNotes()

}