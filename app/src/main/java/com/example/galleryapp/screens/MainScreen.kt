package com.example.galleryapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.galleryapp.data.Photo
import com.example.galleryapp.viewModels.PhotosViewModel

@Composable
fun PhotosScreen(photosViewModel: PhotosViewModel) {
    val photos = photosViewModel.photosLiveData.value

    LaunchedEffect(Unit) {
        photosViewModel.loadPhotos()
    }
    Column {
        LazyColumn {
            items(photos) { photo ->
                PhotoItem(photo)
            }
        }
    }
}

@Composable
fun PhotoItem(photo: Photo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = photo.url)
                        .apply(block = fun ImageRequest.Builder.() {
                            crossfade(true)
                        }).build()
                ),
                contentDescription = photo.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Description(photo = photo)
        }
    }
}

@Composable
fun Description(photo: Photo) {
    Text(
        text = "title: " + photo.title,
        style = MaterialTheme.typography.bodyMedium
    )
    if(photo.dateTaken!=null) {
        Text(
            text = "date taken: " + photo.dateTaken,
            style = MaterialTheme.typography.bodyMedium
        )
    }

    if(photo.ownerName!="") {
        Text(
            text = "owner name: " + photo.ownerName,
            style = MaterialTheme.typography.bodyMedium
        )
    }
    if(photo.tags!="") {
        Text(
            text = "tags: " + photo.tags,
            style = MaterialTheme.typography.bodyMedium
        )
    }

    if(photo.views!=null) {
        Text(
            text = "views: " + photo.views,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
