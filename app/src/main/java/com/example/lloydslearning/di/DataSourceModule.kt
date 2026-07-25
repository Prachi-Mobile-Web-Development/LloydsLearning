package com.example.lloydslearning.di

import com.example.lloydslearning.data.datasource.UsersDataSource
import com.example.lloydslearning.data.datasource.UsersDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindUserDataSource(userDataSourceImpl: UsersDataSourceImpl): UsersDataSource
}