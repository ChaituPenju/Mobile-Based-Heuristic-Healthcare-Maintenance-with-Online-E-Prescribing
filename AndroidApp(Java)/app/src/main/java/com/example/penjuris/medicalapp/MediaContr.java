package com.example.penjuris.medicalapp;

import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MediaContr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_contr);
        final VideoView videoView = (VideoView)
                findViewById(R.id.videoView);
       /* videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.easy));
videoView.start();*/
        String url = getIntent().getStringExtra("URL");
        Uri video = Uri.parse(url);
        videoView.setVideoURI(video);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}
