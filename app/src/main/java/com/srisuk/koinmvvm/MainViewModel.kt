package com.srisuk.koinmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.srisuk.koinmvvm.model.NewResponse
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel(private var reposistory: AppReposistory) : ViewModel(), CoroutineScope {
    private val job = SupervisorJob()
    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->

    }
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + exceptionHandler + job
    private val _response = MutableLiveData<NewResponse>()
    val response: LiveData<NewResponse>
        get() = _response

    fun fetchLogin() {
        launch {
            try {
                val response = reposistory.fetchLogin()
                _response.value = response

            } catch (e: Throwable) {

            }
        }

    }

    override fun onCleared() {
        coroutineContext.cancel()
        super.onCleared()
    }
}