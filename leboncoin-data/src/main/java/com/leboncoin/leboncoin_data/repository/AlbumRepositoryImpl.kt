package com.leboncoin.leboncoin_data.repository

import com.leboncoin.leboncoin_data.local.AlbumDatabase
import com.leboncoin.leboncoin_data.mapper.toAlbum
import com.leboncoin.leboncoin_data.mapper.toAlbumEntity
import com.leboncoin.leboncoin_data.service.AlbumService
import com.leboncoin.leboncoin_domain.entity.Album
import com.leboncoin.leboncoin_domain.repository.AlbumRepository
import com.leboncoin.leboncoin_domain.utils.AlbumError
import com.leboncoin.leboncoin_domain.utils.AlbumResult
import java.net.UnknownHostException
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val albumService: AlbumService,
    private val albumDatabase: AlbumDatabase,
): AlbumRepository {

    override suspend fun getAlbums(): AlbumResult<List<Album>> {
        return try {
            val albums = albumService.getAlbums()
            albumDatabase.dao.upsertAlbums(albums.map { it.toAlbumEntity() })
            AlbumResult.Success(getAlbumsFromDatabase())
        } catch (throwable: Throwable) {
            if (throwable is UnknownHostException)
                AlbumResult.Success(getAlbumsFromDatabase())
            else
                AlbumResult.Failure(AlbumError.Unknown)
        }
    }

    private suspend fun getAlbumsFromDatabase(): List<Album> =
        albumDatabase.dao.getAlbums().map { it.toAlbum() }
}