package com.farooq.core.di

import android.os.Build
import com.farooq.core.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun provideBodyInterceptor(): HttpLoggingInterceptor {
        val httpInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            httpInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return httpInterceptor
    }

    @Provides
    fun provideOkHttpClient(bodyInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .addNetworkInterceptor(bodyInterceptor)
            .addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .method(original.method, original.body)
                val request = requestBuilder.build()
                chain.proceed(request)
            }.build()
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.index.hr/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .client(client)
            .build()
    }
}