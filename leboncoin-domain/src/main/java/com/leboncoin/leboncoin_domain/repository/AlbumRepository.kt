package com.leboncoin.leboncoin_domain.repository

import com.leboncoin.leboncoin_domain.entity.Album

interface AlbumRepository {
    suspend fun getAlbums(): List<Album>
}