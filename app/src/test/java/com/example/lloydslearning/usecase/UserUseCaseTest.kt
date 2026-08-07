package com.example.lloydslearning.usecase

import app.cash.turbine.test
import com.example.lloydslearning.domain.repository.UserRepository
import com.example.lloydslearning.domain.usecase.UsersUseCase
import com.example.lloydslearning.model.Users
import com.example.lloydslearning.presentation.screen.UiState
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UserUseCaseTest {
    val userRepository: UserRepository= mockk()
     lateinit var classToTest: UsersUseCase
    val testDispatcher= StandardTestDispatcher()
    @Before
    fun setUp(){
        Dispatchers.setMain(testDispatcher)
    }
    @After
    fun tearDown(){
        Dispatchers.resetMain()
        clearAllMocks()
    }

    @Test
    fun `test usecase`(){runTest {
        val listOfUsers = mutableListOf(Users(name = "prachi", userName = "prachikhisti", id = 1))

        classToTest = UsersUseCase(userRepository)
        every { userRepository.fetchUsers() } returns flowOf(listOfUsers)
        classToTest().test {
              val success= awaitItem()
            Assert.assertEquals(listOfUsers,success)
            Assert.assertEquals(1,success.size)

            Assert.assertEquals("prachi",success[0].name)
            awaitComplete()
        }
    }


    }

}