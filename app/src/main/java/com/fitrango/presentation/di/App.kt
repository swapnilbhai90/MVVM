package com.fitrango.presentation.di

import android.app.Application
import com.fitrango.BuildConfig
import com.fitrango.presentation.di.core.*
import com.triplerice.recco.presentation.di.movie.LoginSubComponent

class App: Application(),Injector {

    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent=DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("http://triplerice.com/"))
            .remoteDataModule(RemoteDataModule(""))
            .build()


    }

    override fun createLoginSubComponent(): LoginSubComponent {
      return  appComponent.loginSubComponent().create()
    }


}