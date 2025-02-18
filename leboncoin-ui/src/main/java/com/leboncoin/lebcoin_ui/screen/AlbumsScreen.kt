package com.leboncoin.lebcoin_ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.leboncoin.leboncoin_domain.entity.Album

@Composable
fun AlbumsScreen(
    modifier: Modifier = Modifier,
    viewModel: AlbumsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    UIContent(modifier = modifier, state = state)
}

@Composable
private fun UIContent(
    modifier: Modifier = Modifier,
    state: AlbumsScreenState
){
    when{
        state.isLoading -> LoadingScreen()
        state.error != null -> ErrorScreen()
        state.albums.isEmpty() -> NoAlbumsScreen()
        else -> AlbumsUI(modifier = modifier, albums = state.albums)
    }
}

@Composable
private fun AlbumsUI(
    modifier: Modifier = Modifier,
    albums: List<Album>,
){
    LazyColumn(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        item {
            Text(
                text = "Albums",
                style = MaterialTheme.typography.titleLarge,
            )
        }
        items(albums) { album ->
            AlbumItem(album = album)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlbumsLoadingScreenPreview(){
    UIContent(
        state = AlbumsScreenState()
    )
}

@Preview(showBackground = true)
@Composable
fun AlbumsErrorScreenPreview(){
    UIContent(
        state = AlbumsScreenState(isLoading = false, error = "")
    )
}

@Preview(showBackground = true)
@Composable
fun AlbumsScreenPreview(){
    UIContent(
        state = AlbumsScreenState(
            isLoading = false,
            albums = listOf(
                Album(title = "title", thumbnailUrl = "thumbnailUrl"),
                Album(title = "title", thumbnailUrl = "thumbnailUrl"),
                Album(title = "title", thumbnailUrl = "thumbnailUrl"),
                Album(title = "title", thumbnailUrl = "thumbnailUrl"),
                Album(title = "title", thumbnailUrl = "thumbnailUrl"),
            )
        )
    )
}