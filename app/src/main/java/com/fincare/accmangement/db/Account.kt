package com.fincare.accmangement.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
data class Account(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val ActName: String,
    val actid: String,
    val alternateName: String? = null
)