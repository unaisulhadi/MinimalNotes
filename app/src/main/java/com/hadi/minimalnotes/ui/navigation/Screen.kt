package com.hadi.minimalnotes.ui.navigation

sealed class Screen(val route:String){
    object SplashScreen : Screen("splash_screen")
    object NotesScreen : Screen("notes_screen")
    object AddNoteScreen : Screen("add_note_screen")
    object ViewNoteScreen : Screen("view_note_screen")
    object EditNoteScreen : Screen("edit_note_screen")
}
