package com.example.lloydslearning.viewmodel

import app.cash.turbine.test
import com.example.lloydslearning.domain.usecase.UsersUseCase
import com.example.lloydslearning.domain.model.Users
import com.example.lloydslearning.presentation.screen.UiState
import com.example.lloydslearning.presentation.viewmodel.UsersViewModel
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
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
class

UsersViewModelTest {

    private val usersUseCase: UsersUseCase = mockk()
    private val testDispatcher = StandardTestDispatcher()
    private lateinit var classToTest: UsersViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }

    @Test
    fun `fetch user should emit loading then success data when usecase return data`() = runTest {
        val listOfUsers = listOf(Users(name = "prachi khisti", userName = "prachi", id = 1))
        every { usersUseCase() } returns flowOf(listOfUsers)
        classToTest = UsersViewModel(usersUseCase)
        classToTest.usersUiState.test {
            Assert.assertTrue(awaitItem() is UiState.Loading)
            val success = awaitItem()
            Assert.assertTrue(success is UiState.Success)
            success as UiState.Success
            Assert.assertEquals(listOfUsers, success.data)
            cancelAndIgnoreRemainingEvents()

        }
        verify { usersUseCase() }


    }

    @Test
    fun `fetch user should emit error when usecase return exception`() = runTest {

        val errorMessage = "Network failure"
        every { usersUseCase() } returns flow { throw RuntimeException(errorMessage) }
        classToTest = UsersViewModel(usersUseCase)
        classToTest.usersUiState.test {
            Assert.assertTrue(awaitItem() is UiState.Loading)
            val error = awaitItem()
            Assert.assertTrue(error is UiState.Error)
            error as UiState.Error
            Assert.assertEquals(errorMessage, error.message )
            cancelAndIgnoreRemainingEvents()


        }

    }

}





