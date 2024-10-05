package ke.co.banit.flowmart.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ke.co.banit.flowmart.data.repository.AuthRepositoryImpl
import ke.co.banit.flowmart.domain.repository.AuthRepository
import javax.inject.Singleton

/**
 * @Author: Angatia Benson
 * @Date: 10/5/2024
 * Copyright (c) 2024 BanIT
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}