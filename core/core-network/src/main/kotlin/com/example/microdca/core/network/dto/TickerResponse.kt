package com.example.microdca.core.network.dto

data class TickerResponse(
    val retCode: Int,
    val retMsg: String,
    val result: TickerResult
)

data class TickerResult(
    val category: String,
    val list: List<TickerItem>
)

data class TickerItem(
    val symbol: String,
    val lastPrice: String,
    val highPrice24h: String,
    val lowPrice24h: String,
    val volume24h: String,
    val price24hPcnt: String
)