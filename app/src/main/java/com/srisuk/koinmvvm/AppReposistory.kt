package com.srisuk.koinmvvm

import com.srisuk.koinmvvm.model.NewResponse

interface AppReposistory{
    suspend fun fetchLogin():NewResponse
}
class AppRepositoryIml(private var api: AppService):AppReposistory{
    override suspend fun fetchLogin() :NewResponse =api.fetchLogin()
}