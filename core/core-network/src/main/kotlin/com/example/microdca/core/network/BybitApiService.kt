package com.example.microdca.core.network

import com.example.microdca.core.network.dto.KlineResponse
import com.example.microdca.core.network.dto.TickerResponse
import com.example.microdca.core.network.dto.InstrumentsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BybitApiService {

    // contoh buat di postman GET /v5/market/kline?category=spot&symbol=BTCUSDT&interval=D&limit=200
    @GET("v5/market/kline")
    suspend fun getKline(
        @Query("category") category: String = "spot",
        @Query("symbol") symbol: String,
        @Query("interval") interval: String,
        @Query("limit") limit: Int = 200,
        @Query("start") startTime: Long? = null,
        @Query("end") endTime: Long? = null
    ): Response<KlineResponse>

    @GET("v5/market/tickers")
    suspend fun getTicker(
        @Query("category") category: String = "spot",
        @Query("symbol") symbol: String
    ): Response<TickerResponse>

    @GET("v5/market/instruments-info")
    suspend fun getInstruments(
        @Query("category") category: String = "spot"
    ): Response<InstrumentsResponse>
}