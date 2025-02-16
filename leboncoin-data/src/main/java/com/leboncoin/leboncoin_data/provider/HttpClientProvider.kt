package com.leboncoin.leboncoin_data.provider

import io.ktor.client.HttpClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HttpClientProvider @Inject constructor() {
    fun getClient() = HttpClient()
}