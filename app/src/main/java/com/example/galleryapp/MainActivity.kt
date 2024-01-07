package com.example.galleryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.galleryapp.screens.PhotosScreen
import com.example.galleryapp.viewModels.PhotosViewModel

class MainActivity : ComponentActivity() {
    private val photosViewModel: PhotosViewModel by lazy {
        ViewModelProvider(this)[PhotosViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotosScreen(photosViewModel)
        }
    }
}



