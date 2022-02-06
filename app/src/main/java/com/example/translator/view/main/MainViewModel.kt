package com.example.dictionary.view.main

import androidx.lifecycle.LiveData
import com.example.dictionary.model.data.AppState
import com.example.dictionary.utils.ui.parseOnlineSearchResults
import core.viewmodel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainViewModel(private val interactor: MainInteractor) : core.viewmodel.BaseViewModel<AppState>() {


    private val liveDataForViewToObserve: LiveData<AppState> = mutableLiveData


    fun subscribe(): LiveData<AppState> = liveDataForViewToObserve

    override fun getData(word: String, isOnline: Boolean) {
        mutableLiveData.value = AppState.Loading(null)
        cancelJob()
        viewModelCoroutineScope.launch { startInteractor(word, isOnline) }
    }

    private suspend fun startInteractor(word: String, isOnline: Boolean) =
        withContext(Dispatchers.IO) {
            mutableLiveData.postValue(parseOnlineSearchResults(interactor.getData(word, isOnline)))
        }


    override fun handleError(error: Throwable) {
        mutableLiveData.postValue(AppState.Error(error))
    }


    override fun onCleared() {
        mutableLiveData.value = AppState.Success(null)
        super.onCleared()
    }
}