package com.example.lloydslearning.data.datasource

import com.example.lloydslearning.data.remote.UsersApiService
import com.example.lloydslearning.dto.UsersDtoItem
import javax.inject.Inject

class UsersDataSourceImpl @Inject constructor(val usersApiService: UsersApiService): UsersDataSource {
    override suspend fun fetchUsers(): List<UsersDtoItem> {
       return usersApiService.fetchUsers()
    }

}