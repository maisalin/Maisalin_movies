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
        }else if(name.equals("LaCasa")){
            fileHandler1 = new FileHandler("LaCasaA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("LaCasa", this);
            fileHandler2.readFile();
        }
        else if(name.equals("Under")){
            fileHandler1 = new FileHandler("UnderA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Under", this);
            fileHandler2.readFile();
        }
        else if(name.equals("Fallen")){
            fileHandler1 = new FileHandler("FallenA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Fallen", this);
            fileHandler2.readFile();
        }
        else if(name.equals("Before")){
            fileHandler1 = new FileHandler("BeforeA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Before", this);
            fileHandler2.readFile();
        }
        else if(name.equals("After")){
            fileHandler1 = new FileHandler("AfterA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("After", this);
            fileHandler2.readFile();
        }
        else if(name.equals("ToyBoy")){
            fileHandler1 = new FileHandler("ToyBoyA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("ToyBoy", this);
            fileHandler2.readFile();
        }
        else if(name.equals("You")){
            fileHandler1 = new FileHandler("YouA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("You", this);
            fileHandler2.readFile();
        }
        else if(name.equals("Elite")){
            fileHandler1 = new FileHandler("EliteA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Elite", this);
            fileHandler2.readFile();
        }
        else if(name.equals("TheSociety")){
            fileHandler1 = new FileHandler("TheSocietyA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("TheSociety", this);
            fileHandler2.readFile();
        }
        else if(name.equals("Lost")){
            fileHandler1 = new FileHandler("LostA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Lost", this);
            fileHandler2.readFile();
        }
        else if(name.equals("Reasons")){
            fileHandler1 = new FileHandler("ReasonsA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Reasons", this);
            fileHandler2.readFile();
        }
        else if(name.equals("Ghost")){
            fileHandler1 = new FileHandler("GhostA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Ghost", this);
            fileHandler2.readFile();
        }
        else if(name.equals("SpiderMan")){
            fileHandler1 = new FileHandler("SpiderManA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("SpiderMan", this);
            fileHandler2.readFile();
        }
        else if(name.equals("Arrow")){
            fileHandler1 = new FileHandler("ArrowA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Arrow", this);
            fileHandler2.readFile();
        }
        else if(name.equals("TeenWolf")){
            fileHandler1 = new FileHandler("TeenWolfA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("TeenWolf", this);
            fileHandler2.readFile();
        }
        else if(name.equals("Prison")){
            fileHandler1 = new FileHandler("PrisonA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Prison", this);
            fileHandler2.readFile();
        }
        else if(name.equals("Obx")){
            fileHandler1 = new FileHandler("ObxA", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("Obx", this);
            fileHandler2.readFile();
        }
        else if(name.equals("")){
            fileHandler1 = new FileHandler("", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("", this);
            fileHandler2.readFile();
        }
        else if(name.equals("")){
            fileHandler1 = new FileHandler("", this);
            fileHandler1.readFile();
            fileHandler2=new FileHandler("", this);
            fileHandler2.readFile();
        }

    }
}