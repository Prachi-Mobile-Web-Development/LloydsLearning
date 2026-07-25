package com.example.lloydslearning.data.datasource

import com.example.lloydslearning.dto.UsersDtoItem

interface UsersDataSource {
    suspend fun fetchUsers(): List<UsersDtoItem>
}