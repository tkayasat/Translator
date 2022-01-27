package com.example.dictionary.di

import com.example.dictionary.datasource.RetrofitImplementation
import com.example.dictionary.datasource.RoomDataBaseImplementation
import com.example.dictionary.model.Repository
import com.example.dictionary.model.data.DataModel
import com.example.dictionary.model.repository.RepositoryImplementation
import com.example.dictionary.view.main.MainInteractor
import com.example.dictionary.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) {
        RepositoryImplementation(
            RetrofitImplementation()
        )
    }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) {
        RepositoryImplementation(
            RoomDataBaseImplementation()
        )
    }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}
