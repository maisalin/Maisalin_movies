package com.example.maisalin_movies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView tvFileContent;
    private FileHandler fileHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvFileContent = findViewById(R.id.tvFileContent);

        String name =getIntent().getStringExtra("name");
        loadContentByName(name);


        if(fileHandler != null )
        {
            tvFileContent.setText(fileHandler.getContent());
        }

    }

    public void loadContentByName(String name){
        if(name.equals("Divergent")){

        }
    }
}