package com.leboncoin.leboncoin_data

import com.leboncoin.leboncoin_data.local.AlbumDAO
import com.leboncoin.leboncoin_data.local.AlbumDatabase
import com.leboncoin.leboncoin_data.local.AlbumEntity
import com.leboncoin.leboncoin_data.mapper.toAlbum
import com.leboncoin.leboncoin_data.mapper.toAlbumEntity
import com.leboncoin.leboncoin_data.repository.AlbumRepositoryImpl
import com.leboncoin.leboncoin_data.response.AlbumDTO
import com.leboncoin.leboncoin_data.service.AlbumService
import com.leboncoin.leboncoin_domain.repository.AlbumRepository
import com.leboncoin.leboncoin_domain.utils.AlbumError
import com.leboncoin.leboncoin_domain.utils.AlbumResult
import com.leboncoin.leboncoin_domain.utils.AlbumResult.Failure
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.mock
import java.net.UnknownHostException

class AlbumRepositoryTest {

    @Mock
    private lateinit var albumService: AlbumService

    private lateinit var albumDatabase: AlbumDatabase

    @Mock
    private lateinit var albumDAO: AlbumDAO

    private lateinit var albumRepository: AlbumRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        albumDatabase = mock<AlbumDatabase> {
            on { dao }.thenReturn(albumDAO)
        }
        albumRepository = AlbumRepositoryImpl(albumService, albumDatabase)
    }

    @Test
    fun `getAlbums returns Success with albums from database when service fails with UnknownHostException`() = runTest {
        // Arrange
        val expectedAlbumEntities = listOf(
            AlbumEntity(1, 1, "title1", "url1", "https://via.placeholder.com/150/6ffa50"),
            AlbumEntity(2, 2, "title2", "url2", "https://via.placeholder.com/150/6ffa50")
        )

        val expectedAlbums = expectedAlbumEntities.map { it.toAlbum() }

        `when`(albumService.getAlbums()).thenThrow(UnknownHostException())
        `when`(albumDAO.getAlbums()).thenReturn(expectedAlbumEntities)

        // Act
        val result = albumRepository.getAlbums()

        // Assert
        assertEquals(AlbumResult.Success(expectedAlbums), result)
    }

    @Test
    fun `getAlbums returns Failure when service fails with other exception`() = runTest {
        // Arrange
        `when`(albumService.getAlbums()).thenThrow(RuntimeException())

        // Act
        val result = albumRepository.getAlbums()

        // Assert
        assertEquals(AlbumError.Unknown, (result as Failure).error)
    }

    @Test
    fun `getAlbums returns Success with albums from service and updates database`() = runTest {
        // Arrange
        val expectedAlbumsDTO = listOf(
            AlbumDTO(1, 1, "title1", "url1", "https://via.placeholder.com/150/6ffa50"),
            AlbumDTO(2, 2, "title2", "url2", "https://via.placeholder.com/150/6ffa50")
        )
        val expectedAlbumEntities = expectedAlbumsDTO.map { it.toAlbumEntity() }
        val expectedAlbums = expectedAlbumEntities.map { it.toAlbum() }

        `when`(albumService.getAlbums()).thenReturn(expectedAlbumsDTO)
        `when`(albumDAO.getAlbums()).thenReturn(expectedAlbumEntities)

        // Act
        val result = albumRepository.getAlbums()

        // Assert
        assertEquals(AlbumResult.Success(expectedAlbums), result)
    }
}