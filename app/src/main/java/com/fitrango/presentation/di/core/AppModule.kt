package com.fitrango.presentation.di.core

import android.content.Context
import com.triplerice.recco.presentation.di.movie.LoginSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [LoginSubComponent::class])
class AppModule(private val context: Context) {

 @Singleton
 @Provides
 fun provideApplicationContext():Context{
     return context.applicationContext
 }

}