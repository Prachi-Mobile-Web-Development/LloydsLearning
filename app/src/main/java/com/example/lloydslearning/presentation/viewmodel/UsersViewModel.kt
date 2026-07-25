package com.example.lloydslearning.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lloydslearning.domain.usecase.UsersUseCase
import com.example.lloydslearning.model.Users
import com.example.lloydslearning.presentation.screen.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class UsersViewModel @Inject constructor(private val getUsersUseCase: UsersUseCase) : ViewModel() {

    val usersUiState: StateFlow<UiState<List<Users>>> = getUsersUseCase()
        .map { data -> if (data.isEmpty()) UiState.Empty else UiState.Success(data) }
        .onStart { emit(UiState.Loading) }
        .catch { e -> emit(UiState.Error(e.message ?: "Unknown error")) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UiState.Loading)
}

