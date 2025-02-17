package com.leboncoin.leboncoin_domain.usecase

import com.leboncoin.leboncoin_domain.entity.Album
import com.leboncoin.leboncoin_domain.repository.AlbumRepository
import com.leboncoin.leboncoin_domain.utils.AlbumResult
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(
    private val albumRepository: AlbumRepository,
) {
    suspend operator fun invoke(): AlbumResult<List<Album>> = albumRepository.getAlbums()
}