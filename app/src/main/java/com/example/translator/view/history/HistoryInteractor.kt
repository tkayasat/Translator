package com.example.translator.view.history

import com.example.dictionary.model.Repository
import com.example.dictionary.model.data.AppState
import com.example.dictionary.model.data.DataModel
import com.example.dictionary.presenter.Interactor
import com.example.translator.model.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}