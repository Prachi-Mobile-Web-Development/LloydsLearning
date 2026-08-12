package com.example.lloydslearning.domain.repository

import com.example.lloydslearning.domain.model.Users
import kotlinx.coroutines.flow.Flow

interface UserRepository {
     fun fetchUsers(): Flow<List<Users>>
}