package com.example.translator.model.repository

import com.example.dictionary.model.Repository
import com.example.dictionary.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {
    suspend fun saveToDB(appState: AppState)
}