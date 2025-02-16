package com.leboncoin.leboncoin_data.repository

import com.leboncoin.leboncoin_data.mapper.AlbumMapper
import com.leboncoin.leboncoin_data.service.AlbumService
import com.leboncoin.leboncoin_domain.entity.Album
import com.leboncoin.leboncoin_domain.repository.AlbumRepository
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val albumService: AlbumService,
    private val albumMapper: AlbumMapper,
): AlbumRepository {

    override suspend fun getAlbums(): List<Album> =
        albumService.getAlbums().map { albumMapper.map(it) }

}