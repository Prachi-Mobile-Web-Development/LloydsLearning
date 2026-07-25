package com.example.lloydslearning.data.repositoryImpl

import com.example.lloydslearning.data.datasource.UsersDataSource
import com.example.lloydslearning.domain.repository.UserRepository
import com.example.lloydslearning.model.Users
import com.example.lloydslearning.model.toDomain
import com.example.lloydslearning.presentation.screen.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val usersDataSource: UsersDataSource): UserRepository {
    override  fun fetchUsers(): Flow<List<Users>> =flow {
        val data = usersDataSource.fetchUsers()
        val response = data.map { it.toDomain() }
        emit(response)}
    .flowOn(Dispatchers.IO)


}