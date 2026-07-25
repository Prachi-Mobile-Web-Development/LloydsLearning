package com.example.lloydslearning.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lloydslearning.model.Users

@Composable
fun UserListData(users: List<Users>) {
    LazyColumn {
        items(
            items = users,
            key = {
                it.id!!
            }) { usersData ->
            UserListItems(usersData)
        }
    }

}


@Composable
fun UserListItems(users: Users) {
    Column(modifier = Modifier.padding(8.dp)) {
        users.id.toString().let { Text(it, style = MaterialTheme.typography.titleMedium) }

        users.name?.let { Text(it, style = MaterialTheme.typography.titleMedium) }
    }
}
