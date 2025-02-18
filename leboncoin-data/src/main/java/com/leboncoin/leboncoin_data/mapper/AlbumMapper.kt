package com.leboncoin.leboncoin_data.mapper

import com.leboncoin.leboncoin_data.local.AlbumEntity
import com.leboncoin.leboncoin_data.response.AlbumDTO
import com.leboncoin.leboncoin_domain.entity.Album

fun AlbumDTO.toAlbumEntity() = AlbumEntity(
    albumId = this.albumId ?: 0,
    id = this.id ?: 0,
    title = this.title ?: "",
    url = this.url ?: "",
    thumbnailUrl = getThumbnailUrl(this.thumbnailUrl) ?: ""
)

fun AlbumEntity.toAlbum() = Album(
    title = this.title,
    thumbnailUrl = this.thumbnailUrl
)

private fun getThumbnailUrl(url: String?): String? {
    val index = url?.lastIndexOf("/")
    return index?.let { "https://place-hold.it/600".plus(url.substring(index, url.length)) }
}