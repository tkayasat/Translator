package com.example.dictionary.datasource

import com.example.dictionary.model.data.DataModel

class DataSourceRemote(
    private val remoteProvider: RetrofitImplementation = RetrofitImplementation(),
) : com.example.dictionary.datasource.DataSource<List<DataModel>> {

    override suspend fun getData(word: String) = remoteProvider.getData(word)

}