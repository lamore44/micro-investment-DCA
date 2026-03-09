package com.example.microdca.core.network.dto

data class KlineResponse(
    val retCode: Int,
    val retMsg: String,
    val result: KlineResult
)

data class KlineResult(
    val symbol: String,
    val category: String,
    val list: List<List<String>>  // Bybit array mentah kayak di bawah
//    list:[
//        [
//            timestamp,
//            open,
//            high,
//            low,
//            close,
//            volume,
//            turnover
//        ]
//    ]
)