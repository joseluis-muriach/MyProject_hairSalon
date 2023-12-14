package com.example.myproject_hairsalon.WhatIsYourTypeFace.VideoCalculateTypeFace

import android.annotation.SuppressLint
import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

/*
In this class create the design of how will see the video (how it will see the user).
*/
@Composable
fun VideoPlayer(
    videoUri: Uri
){
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .size(550.dp)
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp)),
        factory = { context ->
        VideoView(context).apply {
            setVideoURI(videoUri)

            val mediaController = MediaController(context)
            mediaController.setAnchorView(this)

            setMediaController(mediaController)

            setOnPreparedListener {
                start()
            }
        }
    })
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun Video() {
    val videoUri =
        Uri.parse("android.resource://com.example.myproject_hairsalon/raw/videorostro")

        VideoPlayer(
            videoUri = videoUri
        )
}