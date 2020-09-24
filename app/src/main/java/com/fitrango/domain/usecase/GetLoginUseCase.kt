package com.fitrango.domain.usecase

import com.fitrango.data.model.login.LoginResponse
import com.fitrango.domain.respository.LoginRepository

class GetLoginUseCase(val loginRepository: LoginRepository) {

    suspend fun execute(   fullName: String,
                           fb_id: String,
                           google_id: String,
                           userLocation: String,
                           profile_image: String):LoginResponse?=loginRepository.getSocialLogin(fullName, fb_id, google_id, userLocation, profile_image)

}