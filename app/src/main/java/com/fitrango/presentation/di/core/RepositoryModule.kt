package com.fitrango.presentation.di.core


import com.fitrango.data.repository.login.LoginRepositoryImp
import com.fitrango.data.repository.login.dataSource.LoginDataSource
import com.fitrango.domain.respository.LoginRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(loginRemoteDataSource: LoginDataSource): LoginRepository {

        return LoginRepositoryImp(loginRemoteDataSource)


    }



}