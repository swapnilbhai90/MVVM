package com.triplerice.recco.presentation.di.movie

import com.fitrango.presentation.view.login.LoginActivity
import com.fitrango.presentation.view.splash.SplashActivity
import dagger.Subcomponent

@LoginScope
@Subcomponent(modules = [LoginModule::class])
interface LoginSubComponent {

    fun inject(movieActivity: LoginActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():LoginSubComponent
    }

}

