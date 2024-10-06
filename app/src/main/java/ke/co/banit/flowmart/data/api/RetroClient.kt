package ke.co.banit.flowmart.data.api

import ke.co.banit.flowmart.App
import ke.co.banit.flowmart.R
import ke.co.banit.flowmart.core.SessionManager
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @Author: Angatia Benson
 * @Date: 10/5/2024
 * Copyright (c) 2024 BanIT
 */
class RetroClient {
    companion object {
        private var mHttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private var mOkHttpClient = OkHttpClient
            .Builder()
            .addNetworkInterceptor(Interceptor { chain ->
                val requestBuilder = chain.request().newBuilder()
                requestBuilder.addHeader(
                    "Authorization",
                    "Bearer ${SessionManager.apiKey}"
                )
                chain.proceed(requestBuilder.build())
            })
            .addInterceptor(mHttpLoggingInterceptor)
            .build()

        private var instance: APIService? = null

        fun getApi(): APIService {
            if (instance == null) {
                instance = Retrofit.Builder()
                    .baseUrl(App.application.resources.getString(R.string.api_base_url))
                    .client(mOkHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(APIService::class.java)
            }
            return instance!!
        }
    }
}