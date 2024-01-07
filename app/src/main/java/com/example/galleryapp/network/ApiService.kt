package com.example.galleryapp.network
import com.example.galleryapp.data.PhotosSearchResponse
import com.example.galleryapp.network.ApiConstants.FLICKR_API_KEY
import retrofit2.http.GET

interface ApiService {
    @GET("?method=flickr.photos.search&format=json&nojsoncallback=1&text=dogs&api_key=$FLICKR_API_KEY")
    suspend fun fetchImages(): PhotosSearchResponse
}