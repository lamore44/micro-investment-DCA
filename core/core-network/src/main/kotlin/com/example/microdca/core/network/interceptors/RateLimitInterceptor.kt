package com.example.microdca.core.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import java.util.concurrent.TimeUnit

class RateLimitInterceptor @Inject constructor() : Interceptor {
    private var lastRequestTime = 0L
    private val minIntervalMs = 100L // max 10 requests per second

    override fun intercept(chain: Interceptor.Chain): Response {
        val now = System.currentTimeMillis()
        val elapsed = now - lastRequestTime
        if (elapsed < minIntervalMs) {
            Thread.sleep(minIntervalMs - elapsed)
        }
        lastRequestTime = System.currentTimeMillis()
        return chain.proceed(chain.request())
    }
}