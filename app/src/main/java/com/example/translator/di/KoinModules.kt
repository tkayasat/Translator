package com.example.dictionary.di

import androidx.room.Room
import com.example.dictionary.datasource.RetrofitImplementation
import com.example.dictionary.datasource.RoomDataBaseImplementation
import com.example.dictionary.model.Repository
import com.example.dictionary.model.data.DataModel
import com.example.dictionary.model.repository.RepositoryImplementation
import com.example.dictionary.view.main.MainInteractor
import com.example.dictionary.view.main.MainViewModel
import com.example.translator.model.repository.RepositoryImplementationLocal
import com.example.translator.model.repository.RepositoryLocal
import com.example.translator.room.HistoryDataBase
import com.example.translator.view.history.HistoryInteractor
import com.example.translator.view.history.HistoryViewModel
import org.koin.dsl.module


val application = module {

    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDBase").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> {
        RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}