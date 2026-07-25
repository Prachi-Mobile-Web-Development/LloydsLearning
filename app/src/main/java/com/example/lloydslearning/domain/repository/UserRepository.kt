package com.example.lloydslearning.domain.repository

import com.example.lloydslearning.model.Users
import com.example.lloydslearning.presentation.screen.UiState
import kotlinx.coroutines.flow.Flow

interface UserRepository {
     fun fetchUsers(): Flow<List<Users>>
}