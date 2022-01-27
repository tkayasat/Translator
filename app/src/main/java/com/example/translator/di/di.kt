package com.example.dictionary.di

import com.example.dictionary.datasource.RetrofitImplementation
import com.example.dictionary.di.Di.appModule
import com.example.dictionary.di.Di.mainScreen
import com.example.dictionary.model.Repository
import com.example.dictionary.model.data.DataModel
import com.example.dictionary.model.repository.RepositoryImplementation
import com.example.dictionary.view.main.MainInteractor
import com.example.dictionary.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

object Di {
    private const val NAME_REPO_REMOTE = "Remote repository"


    val appModule = module {
        single<Repository<List<DataModel>>>(qualifier = named(name = NAME_REPO_REMOTE)) {
            RepositoryImplementation(RetrofitImplementation())
        }
        single { MainViewModel(get()) }

    }

    val mainScreen = module {
        factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
        factory { MainViewModel(get()) }
    }

}

val allModules = appModule + mainScreen

