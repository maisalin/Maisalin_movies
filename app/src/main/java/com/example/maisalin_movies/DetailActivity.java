package com.example.maisalin_movies;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class DetailActivity extends AppCompatActivity {

    private TextView tvFileContent,tvFileContent2;
    private FileHandler fileHandler1,fileHandler2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvFileContent = findViewById(R.id.tvFileContent);
        tvFileContent2 = findViewById(R.id.tvFileContent2);

        String name =getIntent().getStringExtra("name");

        loadContentByName(name);

        if(fileHandler1 != null && fileHandler2!=null)
        {
            tvFileContent.setText(fileHandler1.getContent());
            tvFileContent2.setText(fileHandler2.getContent());

        }

    }

    public void loadContentByName(String name){
        if(name.equals("Divergent")){
            fileHandler1 = new FileHandler("DivergentA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Divergent", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.divergent;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }else if(name.equals("LaCasa")){
            fileHandler1 = new FileHandler("LaCasaA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("LaCasa", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.money;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("Under")){
            fileHandler1 = new FileHandler("UnderA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Under", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.under;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("Vampire")) {
            fileHandler1 = new FileHandler("VampireA", this);
            fileHandler1.readFile();
            fileHandler2 = new FileHandler("Vampire", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.vampire;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("Shadow")) {
            fileHandler1 = new FileHandler("ShadowA", this);
            fileHandler1.readFile();
            fileHandler2 = new FileHandler("Shadow", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.shadow;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("Fallen")){
            fileHandler1 = new FileHandler("FallenA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Fallen", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.fallen;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("Before")){
            fileHandler1 = new FileHandler("BeforeA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Before", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.before;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("After")){
            fileHandler1 = new FileHandler("AfterA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("After", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.after;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("ToyBoy")){
            fileHandler1 = new FileHandler("ToyBoyA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("ToyBoy", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.toyboy;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("You")){
            fileHandler1 = new FileHandler("YouA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("You", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.you;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("Elite")){
            fileHandler1 = new FileHandler("EliteA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Elite", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.elite;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("TheSociety")){
            fileHandler1 = new FileHandler("TheSocietyA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("TheSociety", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.thesociety;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("Lost")){
            fileHandler1 = new FileHandler("LostA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Lost", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.lost;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("Reasons")){
            fileHandler1 = new FileHandler("ReasonsA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Reasons", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.reasons;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("Ghost")){
            fileHandler1 = new FileHandler("GhostA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Ghost", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.ghost;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("SpiderMan")){
            fileHandler1 = new FileHandler("SpiderManA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("SpiderMan", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.spider;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("Arrow")){
            fileHandler1 = new FileHandler("ArrowA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Arrow", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.arrow;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("TeenWolf")){
            fileHandler1 = new FileHandler("TeenWolfA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("TeenWolf", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.teen;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("Prison")){
            fileHandler1 = new FileHandler("PrisonA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Prison", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.prison;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("Obx")){
            fileHandler1 = new FileHandler("ObxA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Obx", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.obx;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("Summer")){
            fileHandler1 = new FileHandler("SummerA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Summer", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.summer;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("FriendsW")){
            fileHandler1 = new FileHandler("FriendsWA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("FriendsW", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.friendsw;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("Holidate")){
            fileHandler1 = new FileHandler("HolidateA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Holidate", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.holidate;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("GoWith")){
            fileHandler1 = new FileHandler("GoWithA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("GoWith", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.gowith;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("ToAll")){
            fileHandler1 = new FileHandler("ToAllA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("ToAll", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.toall;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        else if(name.equals("Love")){
            fileHandler1 = new FileHandler("LoveA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Love", this);
            fileHandler2.readFile();

            //adding a suitable video
            VideoView videoView = findViewById(R.id.video_view);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.love;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        }
        /*   else if(name.equals("")){
                    fileHandler1 = new FileHandler("", this);
                    fileHandler1.readFile();
                    fileHandler2=new FileHandler("", this);
                    fileHandler2.readFile();
              }*/

    }
}