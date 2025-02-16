package com.leboncoin.lebcoin_ui.screen

import androidx.lifecycle.ViewModel
import com.leboncoin.leboncoin_domain.usecase.GetAlbumsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(
    private val getAlbumsUseCase: GetAlbumsUseCase,
): ViewModel() {

}