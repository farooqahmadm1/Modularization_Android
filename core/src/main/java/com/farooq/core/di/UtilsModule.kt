package com.farooq.core.di

import com.farooq.core.BuildConfig
import com.farooq.core.utils.Logger
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UtilsModule {

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    fun provideJsonParser(gson: Gson): com.farooq.core.utils.JsonParser {
        return com.farooq.core.utils.GsonParser(gson)
    }

    @Provides
    fun provideLogger(): Logger {
        return Logger("Grep APP", BuildConfig.DEBUG)
    }
}

