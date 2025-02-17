package com.leboncoin.lebcoin_ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leboncoin.leboncoin_domain.entity.Album
import com.leboncoin.leboncoin_domain.usecase.GetAlbumsUseCase
import com.leboncoin.leboncoin_domain.utils.AlbumResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(
    private val getAlbumsUseCase: GetAlbumsUseCase,
): ViewModel() {

    private val _state = MutableStateFlow(AlbumsScreenState())
    val state = _state

    init {
        viewModelScope.launch {
            _state.value = state.value.copy(isLoading = true)
            when(val albums = getAlbumsUseCase()) {
                is AlbumResult.Failure -> {
                    _state.value = _state.value.copy(error = albums.error.toString(), isLoading = false)
                }
                is AlbumResult.Success -> {
                    _state.value = _state.value.copy(albums = albums.data, isLoading = false)
                }
            }
        }
    }
}

data class AlbumsScreenState(
    val isLoading: Boolean = true,
    val albums: List<Album> = emptyList(),
    val error: String? = null,
)

