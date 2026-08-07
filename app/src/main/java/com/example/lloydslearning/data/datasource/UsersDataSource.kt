package com.example.lloydslearning.data.datasource

import com.example.lloydslearning.data.dto.UsersDtoItem

interface UsersDataSource {
    suspend fun fetchUsers(): List<UsersDtoItem>
}