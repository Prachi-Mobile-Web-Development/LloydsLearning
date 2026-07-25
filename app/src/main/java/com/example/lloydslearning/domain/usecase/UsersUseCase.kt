package com.example.lloydslearning.domain.usecase

import com.example.lloydslearning.domain.repository.UserRepository
import com.example.lloydslearning.model.Users
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UsersUseCase @Inject constructor(private val userRepository: UserRepository) {
      operator fun invoke (): Flow<List<Users>>
            =userRepository.fetchUsers()
}