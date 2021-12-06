package com.hadi.minimalnotes.di

import android.app.Application
import com.hadi.minimalnotes.NoteDatabase
import com.hadi.minimalnotes.data.repository.Repository
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return AndroidSqliteDriver(
            schema = NoteDatabase.Schema,
            context = app,
            name = "notes.db"
        )
    }


    @Provides
    @Singleton
    fun providePersonRepository(driver: SqlDriver): Repository {
        return Repository(
            NoteDatabase.invoke(driver)
        )
    }

}