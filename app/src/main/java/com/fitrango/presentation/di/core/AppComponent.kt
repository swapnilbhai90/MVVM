package com.fitrango.presentation.di.core


import com.triplerice.recco.presentation.di.movie.LoginSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
AppModule::class,
NetModule::class,
UseCaseModule::class,
RepositoryModule::class,
RemoteDataModule::class

])
interface AppComponent {

fun loginSubComponent():LoginSubComponent.Factory


}