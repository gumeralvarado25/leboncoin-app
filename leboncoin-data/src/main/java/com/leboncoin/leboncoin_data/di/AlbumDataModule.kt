package com.leboncoin.leboncoin_data.di

import android.content.Context
import androidx.room.Room
import com.leboncoin.leboncoin_data.local.AlbumDatabase
import com.leboncoin.leboncoin_data.repository.AlbumRepositoryImpl
import com.leboncoin.leboncoin_domain.repository.AlbumRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AlbumDataModule {

    @Binds
    @Singleton
    abstract fun bindAlbumRepository(impl: AlbumRepositoryImpl): AlbumRepository

    companion object {
        @Provides
        @Singleton
        fun provideBeerDatabase(@ApplicationContext context: Context): AlbumDatabase {
            return Room.databaseBuilder(
                context,
                AlbumDatabase::class.java,
                "albums.db"
            ).build()
        }
    }
}