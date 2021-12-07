package com.hadi.minimalnotes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hadi.minimalnotes.ui.screens.add_note.AddNoteScreen
import com.hadi.minimalnotes.ui.screens.edit_note.EditNoteScreen
import com.hadi.minimalnotes.ui.screens.notes.NotesScreen
import com.hadi.minimalnotes.ui.screens.splash.SplashScreen
import com.hadi.minimalnotes.ui.screens.view_note.ViewNoteScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ){

        composable(route = Screen.SplashScreen.route){
            SplashScreen(navController = navController)
        }

        composable(route = Screen.NotesScreen.route){
            NotesScreen(navController = navController)
        }

        composable(route = Screen.AddNoteScreen.route){
            AddNoteScreen(navController = navController)
        }

        composable(route = Screen.ViewNoteScreen.route  + "/{noteId}"){
            ViewNoteScreen(navController = navController)
        }

        composable(route = Screen.EditNoteScreen.route  + "/{noteId}"){
            EditNoteScreen(navController = navController)
        }


    }

}