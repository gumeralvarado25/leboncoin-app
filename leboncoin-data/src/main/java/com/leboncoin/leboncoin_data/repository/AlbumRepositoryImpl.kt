package com.leboncoin.leboncoin_data.repository

import com.leboncoin.leboncoin_data.local.AlbumDatabase
import com.leboncoin.leboncoin_data.mapper.toAlbum
import com.leboncoin.leboncoin_data.mapper.toAlbumEntity
import com.leboncoin.leboncoin_data.service.AlbumService
import com.leboncoin.leboncoin_domain.entity.Album
import com.leboncoin.leboncoin_domain.repository.AlbumRepository
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val albumService: AlbumService,
    private val albumDatabase: AlbumDatabase,
): AlbumRepository {

    override suspend fun getAlbums(): List<Album> {
        val albums = albumService.getAlbums()
        albumDatabase.dao.upsertAlbums(albums.map { it.toAlbumEntity() })
        return albumDatabase.dao.getAlbums().map { it.toAlbum() }
    }
}