package com.triplerice.recco.presentation.di.movie

import com.fitrango.presentation.view.LoginActivity
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

