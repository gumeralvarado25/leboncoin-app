package com.leboncoin.leboncoin_data.mapper

import com.leboncoin.leboncoin_data.local.AlbumEntity
import com.leboncoin.leboncoin_data.response.AlbumDTO
import com.leboncoin.leboncoin_domain.entity.Album

fun AlbumDTO.toAlbumEntity() = AlbumEntity(
    albumId = this.albumId ?: 0,
    id = this.id ?: 0,
    title = this.title ?: "",
    url = this.url ?: "",
    thumbnailUrl = this.thumbnailUrl ?: ""
)

fun AlbumEntity.toAlbum() = Album(
    albumId = this.albumId,
    id = this.id,
    title = this.title,
    url = this.url,
    thumbnailUrl = this.thumbnailUrl
)