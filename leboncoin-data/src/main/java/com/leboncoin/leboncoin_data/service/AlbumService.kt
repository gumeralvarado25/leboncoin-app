package com.leboncoin.leboncoin_data.service

import com.leboncoin.leboncoin_data.provider.HttpClientProvider
import com.leboncoin.leboncoin_data.response.AlbumDTO
import io.ktor.client.call.body
import io.ktor.client.request.get
import java.net.UnknownHostException
import javax.inject.Inject

class AlbumService @Inject constructor(
    private val httpClientProvider: HttpClientProvider,
) {
    @Throws(UnknownHostException::class)
    internal suspend fun getAlbums(): List<AlbumDTO> =
        httpClientProvider.getClient()
            .get("https://static.leboncoin.fr/img/shared/technical-test.json")
            .body()
}