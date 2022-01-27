package com.example.dictionary.model.repository

import com.example.dictionary.datasource.DataSource
import com.example.dictionary.datasource.RetrofitImplementation
import com.example.dictionary.datasource.RoomDataBaseImplementation
import com.example.dictionary.model.Repository
import com.example.dictionary.model.data.DataModel

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}
