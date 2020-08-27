package com.srisuk.koinmvvm.di

import com.srisuk.koinmvvm.AppReposistory
import com.srisuk.koinmvvm.AppRepositoryIml
import com.srisuk.koinmvvm.AppService
import com.srisuk.koinmvvm.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://run.mocky.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<AppService> { get<Retrofit>().create(AppService::class.java) }
    single<AppReposistory> { AppRepositoryIml(get()) }
    viewModel { MainViewModel(get()) }
}