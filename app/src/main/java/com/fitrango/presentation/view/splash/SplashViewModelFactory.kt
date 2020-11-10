package com.fitrango.presentation.view.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fitrango.domain.usecase.GetLoginUseCase

class SplashViewModelFactory():ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(NetModulemodelClass: Class<T>): T {

        return SplashViewModel() as T
    }
}