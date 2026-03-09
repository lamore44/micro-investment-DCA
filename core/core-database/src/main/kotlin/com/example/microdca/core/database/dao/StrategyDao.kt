package com.example.microdca.core.database.dao

import androidx.room.*
import com.example.microdca.core.database.entity.StrategyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StrategyDao {

    @Query("SELECT * FROM strategies ORDER BY createdAt DESC")
    fun observeAll(): Flow<List<StrategyEntity>>

    @Query("SELECT * FROM strategies WHERE id = :id")
    suspend fun getById(id: String): StrategyEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(strategy: StrategyEntity)

    @Delete
    suspend fun delete(strategy: StrategyEntity)

    @Query("UPDATE strategies SET isActive = :isActive WHERE id = :id")
    suspend fun setActive(id: String, isActive: Boolean)
}