package com.example.microdca.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "strategies")
data class StrategyEntity(
    @PrimaryKey val id: String,
    val name: String,
    val symbol: String,
    val investmentAmount: String,
    val frequencyDays: Int,
    val createdAt: Long,
    val isActive: Boolean
)