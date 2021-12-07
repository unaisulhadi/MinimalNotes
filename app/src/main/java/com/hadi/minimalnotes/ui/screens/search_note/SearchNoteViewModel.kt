package com.hadi.minimalnotes.ui.screens.search_note

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hadi.minimalnotes.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import notedb.NoteEntity
import javax.inject.Inject

@HiltViewModel
class SearchNoteViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    var searchText by mutableStateOf("")
        private set

    var notes by mutableStateOf<Flow<List<NoteEntity>>>(flowOf(emptyList()))

    fun setSearchField(value: String) {
        this.searchText = value
        notes = flowOf(emptyList())
        if(value.isNotBlank()) {
            searchNote(value)
        }
    }

    private fun searchNote(value: String) {
        notes = repository.searchNote(value)
    }

}
