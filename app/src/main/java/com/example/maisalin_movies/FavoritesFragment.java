package com.example.maisalin_movies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FavoritesFragment extends Fragment {
    @Nullable
    //the object of the view - design
    private ListView myListView;
    //the object for the adapter connecting the data to the view
    private CustomAdapter myAdapter;
    //object containing the items to be displayed - Data
    private ArrayList<Item> list;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorites,container,false);



        list = new ArrayList<>();


        list.add(new Item("my first item",R.drawable.img,true,50));
        list.add(new Item("idk",R.drawable.img,true,34));
        list.add(new Item("this is supposed to be a string",R.drawable.img,true,74));
        list.add(new Item("weeeeee",R.drawable.img,true,21));
        myListView = findViewById(R.id.myListView);

        //connect adapter with data
        myAdapter = new CustomAdapter(this, R.layout.moviesrow, list);

        //connect adapter with view
        myListView.setAdapter(myAdapter);

        //
        myListView.setDivider(null);
        //connects click listener to items in the list

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Item:" +list.get(i),Toast.LENGTH_LONG).show();
            }
        });
    }
}
