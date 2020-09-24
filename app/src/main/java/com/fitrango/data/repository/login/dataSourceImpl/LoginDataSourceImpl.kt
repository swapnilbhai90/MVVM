package com.fitrango.data.repository.login.dataSourceImpl

import com.fitrango.data.api.FitrangoApiService
import com.fitrango.data.model.login.LoginResponse
import com.fitrango.data.repository.login.dataSource.LoginDataSource
import retrofit2.Response

class LoginDataSourceImpl(val fitrangoApiService: FitrangoApiService):LoginDataSource {
    override suspend fun getSocialLogin(
        fullName: String,
        fb_id: String,
        google_id: String,
        userLocation: String,
        profile_image: String
    ): Response<LoginResponse> =
        fitrangoApiService.socialLoginApi(fullName,fb_id, google_id, userLocation, profile_image)

}