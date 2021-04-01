package com.example.validateapp.api

import com.example.validateapp.data.Rules
import retrofit2.Response
import retrofit2.http.GET

interface RulesApi {
    companion object{
        const val BASE_URL = "https://api.mocki.io/v1/0f84c727/"
    }
    @GET(".") suspend fun getRules() : Response<Rules>
}
