package com.example.microdca.core.database.dao

import androidx.room.*
import com.example.microdca.core.database.entity.KlineEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface KlineDao {

    @Query("""
        SELECT * FROM klines 
        WHERE symbol = :symbol AND interval = :interval 
        ORDER BY openTime DESC 
        LIMIT :limit
    """)
    fun observeKlines(symbol: String, interval: String, limit: Int = 200): Flow<List<KlineEntity>>

    @Query("""
        SELECT * FROM klines 
        WHERE symbol = :symbol AND interval = :interval 
        ORDER BY openTime DESC 
        LIMIT :limit
    """)
    suspend fun getKlines(symbol: String, interval: String, limit: Int = 200): List<KlineEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(klines: List<KlineEntity>)

    @Query("DELETE FROM klines WHERE symbol = :symbol AND interval = :interval")
    suspend fun clearKlines(symbol: String, interval: String)

    @Query("SELECT COUNT(*) FROM klines WHERE symbol = :symbol AND interval = :interval")
    suspend fun getCount(symbol: String, interval: String): Int
}