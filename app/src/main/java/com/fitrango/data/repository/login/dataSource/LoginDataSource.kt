package com.fitrango.data.repository.login.dataSource

import com.fitrango.data.model.login.LoginResponse
import retrofit2.Response

interface LoginDataSource {

    suspend fun getSocialLogin(
        fullName: String,
        fb_id: String,
        google_id: String,
        userLocation: String,
        profile_image: String
    ): Response<LoginResponse>
}