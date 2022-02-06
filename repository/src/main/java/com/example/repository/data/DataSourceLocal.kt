package com.example.translator.presenter

import com.example.dictionary.datasource.DataSource
import com.example.dictionary.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {
    suspend fun saveToDB(appState: AppState)
}