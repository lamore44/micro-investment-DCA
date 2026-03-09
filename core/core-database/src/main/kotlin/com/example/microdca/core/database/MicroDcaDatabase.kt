package com.example.microdca.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.microdca.core.database.converter.BigDecimalConverter
import com.example.microdca.core.database.converter.DateConverter
import com.example.microdca.core.database.dao.*
import com.example.microdca.core.database.entity.*

@Database(
    entities = [
        KlineEntity::class,
        StrategyEntity::class,
        BacktestResultEntity::class,
        PortfolioEntity::class,
        SyncQueueEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(BigDecimalConverter::class, DateConverter::class)
abstract class MicroDcaDatabase : RoomDatabase() {
    abstract fun klineDao(): KlineDao
    abstract fun strategyDao(): StrategyDao
    abstract fun backtestResultDao(): BacktestResultDao
    abstract fun portfolioDao(): PortfolioDao
}