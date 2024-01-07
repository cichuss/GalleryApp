package com.example.galleryapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.galleryapp.data.Photo
import com.example.galleryapp.viewModels.PhotosViewModel


@Composable
fun PhotoItem(photo: Photo) {
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current).data(data = photo.url).apply(block = fun ImageRequest.Builder.() {
                crossfade(true)
            }).build()
        ),        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .clip(shape = RectangleShape)
            .clickable(onClick = {
            }
            )
            .padding(5.dp),
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun PhotosScreen(photosViewModel: PhotosViewModel) {
    val photos = photosViewModel.photosLiveData.value

    LaunchedEffect(Unit) {
        photosViewModel.loadPhotos()
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .height(500.dp)
    ) {
        items(photos) { photo ->
            PhotoItem(photo)
        }
    }
}

