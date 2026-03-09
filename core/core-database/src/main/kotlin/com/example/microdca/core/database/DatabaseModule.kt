package com.example.microdca.core.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideMicroDcaDatabase(
        @ApplicationContext context: Context
    ): MicroDcaDatabase = Room.databaseBuilder(
        context,
        MicroDcaDatabase::class.java,
        "microdca.db"
    ).fallbackToDestructiveMigration().build() // swap dulu sebelum production inihh!!

    @Provides fun provideKlineDao(db: MicroDcaDatabase) = db.klineDao()
    @Provides fun provideStrategyDao(db: MicroDcaDatabase) = db.strategyDao()
    @Provides fun provideBacktestResultDao(db: MicroDcaDatabase) = db.backtestResultDao()
    @Provides fun providePortfolioDao(db: MicroDcaDatabase) = db.portfolioDao()
}