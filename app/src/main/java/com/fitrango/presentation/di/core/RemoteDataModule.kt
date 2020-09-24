package com.fitrango.presentation.di.core

import com.fitrango.data.api.FitrangoApiService
import com.fitrango.data.repository.login.dataSource.LoginDataSource
import com.fitrango.data.repository.login.dataSourceImpl.LoginDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(fitrangoApiService: FitrangoApiService): LoginDataSource {

        return LoginDataSourceImpl(fitrangoApiService)
    }




}