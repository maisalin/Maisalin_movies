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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavoritesFragment extends Fragment {


    private ArrayList<MovieItem> movieItems = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fav2, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new MovieAdapter(movieItems, getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        movieItems.add(new MovieItem(R.drawable.bridgerton, "bridgerton","0","0"));
        movieItems.add(new MovieItem(R.drawable.movie1, "idk","0","0"));
        movieItems.add(new MovieItem(R.drawable.lucifer, "idk","0","0"));
        movieItems.add(new MovieItem(R.drawable.movie3, "","0","0"));
        movieItems.add(new MovieItem(R.drawable.movie4, "idk10","0","0"));


        return root;

    }
}
