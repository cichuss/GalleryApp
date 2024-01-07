package com.example.galleryapp.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.galleryapp.data.Photo
import com.example.galleryapp.network.WebClient
import kotlinx.coroutines.launch

class PhotosViewModel : ViewModel() {
    private val _photosLiveData: MutableState<List<Photo>> = mutableStateOf(emptyList())
    val photosLiveData: MutableState<List<Photo>> = _photosLiveData

    fun loadPhotos() {
        viewModelScope.launch {
            val searchResponse = WebClient.client.fetchImages()
            val photosList = searchResponse.photos.photo.map { photo ->
                Photo(
                    id = photo.id,
                    url = "https://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg",
                    title = photo.title
                )
            }
            _photosLiveData.value = photosList
        }
    }
}