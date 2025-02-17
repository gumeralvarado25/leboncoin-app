package com.leboncoin.leboncoin_data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlbumDTO(
    @SerialName("albumId") val albumId: Int? = null,
    @SerialName("id") val id: Int? = null,
    @SerialName("title") val title: String? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("thumbnailUrl") val thumbnailUrl: String? = null
)
