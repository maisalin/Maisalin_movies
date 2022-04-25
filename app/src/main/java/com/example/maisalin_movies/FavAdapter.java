package com.example.maisalin_movies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class FavAdapter extends ArrayAdapter<MovieItem> {
    private int resource;
    private Context context;

    public FavAdapter(@NonNull Context context, int resource, @NonNull List<MovieItem> objects){
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null)
            view = LayoutInflater.from(context).inflate(resource, parent, false);

        //method from the android studio, not related to Item object (the class we created).
         MovieItem movieItem = getItem(position);

        if(movieItem != null) {
            TextView textViewDescription = view.findViewById(R.id.textViewDesc);
            textViewDescription.setText(movieItem.getTitle());
            ImageView imageView=view.findViewById(R.id.imageItem);
            imageView.setImageResource(movieItem.getImageResource());
        }
        return view;
    }

}
