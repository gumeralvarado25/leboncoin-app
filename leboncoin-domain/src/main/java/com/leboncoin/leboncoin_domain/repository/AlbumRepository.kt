package com.leboncoin.leboncoin_domain.repository

import com.leboncoin.leboncoin_domain.entity.Album
import com.leboncoin.leboncoin_domain.utils.AlbumResult

interface AlbumRepository {
    suspend fun getAlbums(): AlbumResult<List<Album>>
}