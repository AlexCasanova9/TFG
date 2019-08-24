package com.uc3m.foodanalyzerbot.data.repository.datasources.api

import com.google.gson.GsonBuilder
import com.uc3m.foodanalyzerbot.BuildConfig
import com.uc3m.foodanalyzerbot.data.repository.datasources.api.common.ApiClientGenerator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.SECONDS

open class RetrofitDialogFlowApiClientGenerator : ApiClientGenerator {

    companion object {
        private const val SECURITY_CHANNEL = "18"
    }

    private val retrofit: Retrofit by lazy { buildRetrofit() }

    private fun buildRetrofit(): Retrofit {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(60, SECONDS)
            .readTimeout(60, SECONDS)
            .writeTimeout(60, SECONDS)

        tokenCaptorInterceptor()?.let(okHttpClientBuilder::addInterceptor)

        val builder = Retrofit.Builder()
            .baseUrl(buildBaseUrl())
            .addConverterFactory(jsonConverter())
            .client(okHttpClientBuilder.build())

        return builder.build()
    }

    protected open fun buildBaseUrl() = BuildConfig.BaseUrl

    protected open fun jsonConverter(): GsonConverterFactory {
        val gson = GsonBuilder()
            .enableComplexMapKeySerialization()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create()

        return GsonConverterFactory.create(gson)
    }

    override fun <T> generatedApi(service: Class<T>): T = retrofit.create(service)

    protected open fun tokenCaptorInterceptor(): Interceptor? = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "*/*")
            .addHeader("CODCanal", SECURITY_CHANNEL)
            .addHeader("Authorization", "Bearer " + BuildConfig.X_TOKEN_ACCESS)
        chain.proceed(request.build())
    }

}