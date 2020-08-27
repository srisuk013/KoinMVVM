package com.srisuk.koinmvvm

import com.srisuk.koinmvvm.model.NewResponse
import retrofit2.http.GET

interface AppService {
    @GET("/v3/6f38141a-18e5-4931-b3f5-c01bd6dd3b6a")
    suspend fun fetchLogin(): NewResponse
}