package com.example.maisalin_movies;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class DetailActivity extends AppCompatActivity {

    private TextView tvFileContent,tvFileContent2;
    private FileHandler fileHandler;
    private  VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvFileContent = findViewById(R.id.tvFileContent);
        tvFileContent2 = findViewById(R.id.tvFileContent2);
        videoView = findViewById(R.id.video_view);

        //me
        //VideoView videoView = findViewById(R.id.video_view);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.divergent;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        //end
        String name =getIntent().getStringExtra("name");

        loadContentByName(name);


        if(fileHandler != null )
        {
            tvFileContent.setText(fileHandler.getContent());
            tvFileContent2.setText(fileHandler.getContent());

        }

    }

    public void loadContentByName(String name){
        if(name.equals("Divergent")){
            fileHandler = new FileHandler("Divergent", this);
            fileHandler.readFile();
        }else if(name.equals("")){
            fileHandler = new FileHandler("", this);
            fileHandler.readFile();
        }
    }
}