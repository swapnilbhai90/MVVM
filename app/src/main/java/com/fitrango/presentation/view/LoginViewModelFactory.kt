package com.fitrango.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fitrango.domain.usecase.GetLoginUseCase

class LoginViewModelFactory(val  getLoginUseCase: GetLoginUseCase):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(NetModulemodelClass: Class<T>): T {

        return LoginViewModel(getLoginUseCase) as T
    }
}