package com.fitrango.domain.respository

import com.fitrango.data.model.login.LoginResponse

interface LoginRepository {
    suspend fun  getSocialLogin(fullName: String,
                                fb_id: String,
                                google_id: String,
                                userLocation: String,
                                profile_image: String):LoginResponse?
}