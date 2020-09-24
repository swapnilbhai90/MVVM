package com.fitrango.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.fitrango.domain.usecase.GetLoginUseCase

class LoginViewModel(val getLoginUseCase: GetLoginUseCase): ViewModel() {

    fun getMovies(fullName: String,
                  fb_id: String,
                  google_id: String,
                  userLocation: String,
                  profile_image: String)= liveData {
        val loginResponse=getLoginUseCase.execute(fullName, fb_id, google_id, userLocation, profile_image)
        emit(loginResponse)
    }
}