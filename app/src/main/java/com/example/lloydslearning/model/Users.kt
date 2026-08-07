package com.example.lloydslearning.model

import com.example.lloydslearning.data.dto.UsersDtoItem

data class Users(val name:String?,val userName:String?,val id:Int?)

fun UsersDtoItem.toDomain(): Users= Users(
    name=this.name,
    userName=this.userName,
    id=this.id
)







