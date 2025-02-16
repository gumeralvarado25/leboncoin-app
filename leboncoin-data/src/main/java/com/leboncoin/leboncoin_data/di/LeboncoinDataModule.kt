package com.leboncoin.leboncoin_data.di

import com.leboncoin.leboncoin_data.repository.AlbumRepositoryImpl
import com.leboncoin.leboncoin_domain.repository.AlbumRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LeboncoinDataModule {
    @Binds
    @Singleton
    abstract fun bindAlbumRepository(impl: AlbumRepositoryImpl): AlbumRepository
}