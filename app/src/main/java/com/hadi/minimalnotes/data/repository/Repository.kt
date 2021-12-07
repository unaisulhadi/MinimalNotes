package com.hadi.minimalnotes.data.repository

import com.hadi.minimalnotes.NoteDatabase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import notedb.NoteEntity
import javax.inject.Inject

class Repository @Inject constructor(private val db: NoteDatabase) {

    private val queries = db.noteEntityQueries

    fun getAllNotes() = queries.getAllNotes().asFlow().mapToList()

    suspend fun getNoteById(id: Long): NoteEntity? {
        return withContext(Dispatchers.IO) {
            queries.getNoteById(id).executeAsOneOrNull()
        }
    }

    suspend fun insertNote(title: String, content: String, date: String, id: Long? = null) {
        withContext(Dispatchers.IO) {
            queries.insertNote(id, title, content, date)
        }
    }

    suspend fun deleteNoteById(id: Long) {
        withContext(Dispatchers.IO) {
            queries.deleteNoteById(id)
        }
    }

    fun searchNote(keyword: String): Flow<List<NoteEntity>> {
        return queries.searchNotes(keyword).asFlow().mapToList()

    }

}