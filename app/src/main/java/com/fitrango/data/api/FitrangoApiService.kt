package com.fitrango.data.api

import com.fitrango.data.model.login.LoginResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FitrangoApiService {

    @GET("recco_api/recco_login.php")
    suspend fun socialLoginApi(
        @Query("full_name") full_name: String,
        @Query("fb_id") fb_id: String,
        @Query("google_id") google_id: String,
        @Query("userLocation") userLocation: String,
        @Query("profile_image") profile_image: String,

    ): Response<LoginResponse>
}