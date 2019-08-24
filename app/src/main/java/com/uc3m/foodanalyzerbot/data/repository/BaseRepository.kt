package com.uc3m.foodanalyzerbot.data.repository

import com.uc3m.foodanalyzerbot.domain.exception.HttpException
import com.uc3m.foodanalyzerbot.domain.exception.RepositoryException
import com.uc3m.foodanalyzerbot.domain.exception.ServiceUnavailableException
import com.uc3m.foodanalyzerbot.domain.interactor.AsyncCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

abstract class BaseRepository {

    protected open fun <T> executeCall(call: Call<T>): T {
        try {
            val response = call.execute()

            if (!response.isSuccessful) {
                handleHttpError(response)
            }

            response.body()?.let { return it }
                ?: throw  RepositoryException("Body response is null")
        } catch (e: IOException) {
            throw ServiceUnavailableException()
        }
    }

    interface ResponseProcessor<out T, R> {
        fun process(response: Response<R>?): T
    }

    protected fun <T, R> enqueue(
        call: Call<R>,
        asyncCallback: AsyncCallback<T>,
        responseProcessor: ResponseProcessor<T, R>
    ) {
        call.enqueue(object : Callback<R> {
            override fun onResponse(call: Call<R>, response: Response<R>) {
                try {
                    asyncCallback.onSuccess(responseProcessor.process(response))
                } catch (t: Throwable) {
                    asyncCallback.onError(t)
                }
            }

            override fun onFailure(call: Call<R>, t: Throwable) {
                if (t is IOException) {
                    asyncCallback.onError(handleIOException())
                } else {
                    asyncCallback.onError(RepositoryException(t.message))
                }
            }
        })
    }

    private fun handleIOException(): RuntimeException {
        return ServiceUnavailableException()
    }

    @Throws(IOException::class)
    protected open fun <T> handleHttpError(response: Response<T>) {
        throw HttpException(response)
    }
}