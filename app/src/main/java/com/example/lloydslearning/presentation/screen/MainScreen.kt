package com.example.lloydslearning.presentation.screen

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.lloydslearning.presentation.viewmodel.UsersViewModel

@Composable
fun MainScreen(usersViewModel: UsersViewModel = hiltViewModel()) {
    val state by usersViewModel.usersUiState.collectAsStateWithLifecycle()

    when (val user = state) {
        is UiState.Loading ->
            CircularProgressIndicator()

        is UiState.Empty ->
            Text("No Data")

        is UiState.Success ->
            UserListData(user.data)

        is UiState.Error ->
            Text(user.message)

    }
}