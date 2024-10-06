package ke.co.banit.flowmart.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ke.co.banit.flowmart.data.api.APIService
import ke.co.banit.flowmart.data.api.RetroClient

/**
 * @Author: Angatia Benson
 * @Date: 10/5/2024
 * Copyright (c) 2024 BanIT
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideApiService(): APIService {
        return RetroClient.getApi()
    }
}