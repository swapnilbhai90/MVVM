package com.triplerice.recco.presentation.di.movie


import com.fitrango.domain.usecase.GetLoginUseCase
import com.fitrango.presentation.view.LoginViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class LoginModule {
    @LoginScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetLoginUseCase

    ): LoginViewModelFactory {
        return LoginViewModelFactory(
            getMoviesUseCase
        )
    }

}