package com.example.galleryapp.data

data class Photo(
    val id: String,
    val url: String,
    val title: String,
    val dateTaken: String?,
    val ownerName: String?,
    val tags: String?,
    val views: String?
)