package com.fitrango.presentation.di

import com.triplerice.recco.presentation.di.movie.LoginSubComponent

interface Injector {
   fun createLoginSubComponent():LoginSubComponent

}