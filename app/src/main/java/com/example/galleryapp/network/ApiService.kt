package com.example.galleryapp.network
import com.example.galleryapp.data.PhotosSearchResponse
import retrofit2.http.GET

interface ApiService {
    @GET("?method=flickr.interestingness.getList&api_key=${ApiConstants.FLICKR_API_KEY}&per_page=500&format=json&nojsoncallback=1&extras=date_taken,owner_name,tags,views")
    suspend fun fetchImages(): PhotosSearchResponse
}