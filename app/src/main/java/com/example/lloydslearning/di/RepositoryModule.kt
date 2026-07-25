package com.example.lloydslearning.di

import com.example.lloydslearning.data.repositoryImpl.UserRepositoryImpl
import com.example.lloydslearning.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindUserRepositoryImpl(userRepositoryImpl: UserRepositoryImpl): UserRepository
}