package com.hadi.minimalnotes.ui.screens.view_note

import androidx.lifecycle.ViewModel
import com.hadi.minimalnotes.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewNoteViewModel @Inject constructor(private val repository: Repository) : ViewModel(){

}