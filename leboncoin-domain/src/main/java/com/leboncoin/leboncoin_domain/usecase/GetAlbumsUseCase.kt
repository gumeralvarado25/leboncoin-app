package com.leboncoin.leboncoin_domain.usecase

import com.leboncoin.leboncoin_domain.entity.Album
import com.leboncoin.leboncoin_domain.repository.AlbumRepository
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(
    private val albumRepository: AlbumRepository,
) {
    suspend operator fun invoke(): List<Album> = albumRepository.getAlbums()
}