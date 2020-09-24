package com.fitrango.data.repository.login

import com.fitrango.data.model.login.LoginResponse
import com.fitrango.data.repository.login.dataSource.LoginDataSource
import com.fitrango.domain.respository.LoginRepository
import retrofit2.Response
import java.lang.Exception

class LoginRepositoryImp(val  loginDataSource: LoginDataSource):LoginRepository {

    override suspend fun getSocialLogin(
        fullName: String,
        fb_id: String,
        google_id: String,
        userLocation: String,
        profile_image: String
    ): LoginResponse? {
        return loginDataSource.getSocialLogin(fullName, fb_id, google_id, userLocation, profile_image).body()
    }


}