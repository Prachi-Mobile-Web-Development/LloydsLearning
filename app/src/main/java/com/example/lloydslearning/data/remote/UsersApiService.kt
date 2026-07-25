package com.example.lloydslearning.data.remote

import com.example.lloydslearning.dto.UsersDtoItem
import retrofit2.http.GET

interface UsersApiService {
@GET("users")
suspend fun fetchUsers(): List<UsersDtoItem>

}