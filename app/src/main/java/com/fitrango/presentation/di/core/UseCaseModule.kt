package com.fitrango.presentation.di.core


import com.fitrango.domain.respository.LoginRepository
import com.fitrango.domain.usecase.GetLoginUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun providesLoginDataSource(movieRepository: LoginRepository):GetLoginUseCase{
        return GetLoginUseCase(movieRepository)
    }


}