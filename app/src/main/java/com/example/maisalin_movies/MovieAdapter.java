package com.example.maisalin_movies;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends ArrayAdapter<MovieItem> {

    private int resource;
    private Context context;
    private FirebaseAuth maFirebaseAuth = FirebaseAuth.getInstance();
    private String UID = maFirebaseAuth.getUid();
    private FirebaseDatabase database = FirebaseDatabase.getInstance("https://maisalin-movies-default-rtdb.firebaseio.com/");
    private DatabaseReference myRef = database.getReference("profiles/" + UID + "/favorites");


    public MovieAdapter(@NonNull Context context, int resource, @NonNull List<MovieItem> objects) {
        super(context, resource,objects);
        this.context = context;
        this.resource = resource;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null)
            view = LayoutInflater.from(context).inflate(resource, parent, false);

        //method from the android studio, not related to Item object (the class we created).
        MovieItem item = getItem(position);

        if (item != null) {
            TextView textViewDescription = view.findViewById(R.id.titleTextView);
            textViewDescription.setText(item.toString());
            ImageView imageView=view.findViewById(R.id.imageView);
            imageView.setImageResource(item.getImageResource());


            ImageView favorite = view.findViewById(R.id.favorite);
            favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myRef.push().setValue(item);
                    favorite.setImageResource(R.drawable.ic_baseline_favorite2_24);
                }
            });
        }
        return view;
    }

}