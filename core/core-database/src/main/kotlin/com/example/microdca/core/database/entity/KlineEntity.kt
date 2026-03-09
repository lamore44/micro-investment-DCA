package com.example.microdca.core.database.entity

import androidx.room.Entity
import androidx.room.Index

@Entity(
    tableName = "klines",
    primaryKeys = ["symbol", "interval", "openTime"],
    indices = [Index(value = ["symbol", "interval"])]
)
data class KlineEntity(
    val symbol: String,
    val interval: String,
    val openTime: Long,
    val openPrice: String,
    val highPrice: String,
    val lowPrice: String,
    val closePrice: String,
    val volume: String,
    val turnover: String
)