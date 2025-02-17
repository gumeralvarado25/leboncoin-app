package com.leboncoin.leboncoin_data.mapper

import com.leboncoin.leboncoin_data.response.AlbumDTO
import com.leboncoin.leboncoin_domain.entity.Album
import javax.inject.Inject

class AlbumMapper @Inject constructor() {
    fun map(from: AlbumDTO): Album {
        return Album(
            albumId = from.albumId ?: 0,
            id = from.id ?: 0,
            title = from.title ?: "",
            url = from.url ?: "",
            thumbnailUrl = from.thumbnailUrl ?: ""
        )
    }
}