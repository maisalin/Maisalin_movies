package com.example.maisalin_movies;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;


public class FavoritesFragment extends Fragment {

    //the object of the view - design
    private ListView myListView;
    //object containing the items to be displayed - Data
    private ArrayList<MovieItem> list;
    //the object for the adapter connecting the data to the view
    private FavAdapter myAdapter;
    private FirebaseAuth maFirebaseAuth = FirebaseAuth.getInstance();
    private String UID = maFirebaseAuth.getUid();
    private FirebaseDatabase database = FirebaseDatabase.getInstance("https://maisalin-movies-default-rtdb.firebaseio.com/");
    private DatabaseReference myRef = database.getReference("profiles/" + UID + "/favorites");

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_favorites, container, false);
        super.onCreate(savedInstanceState);


        list = new ArrayList<>();

        //reference to the list view so it can be programmed
        myListView = root.findViewById(R.id.myListView2);


        //connect adapter with data
        myAdapter = new FavAdapter(getContext(), R.layout.fav_item, list);

        //connect adapter with view
        myListView.setAdapter(myAdapter);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                MovieItem movieItem = snapshot.getValue(MovieItem.class);
                list.add(movieItem);
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //connects click listener to items in the list
       /* myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //myRef.push().setValue(new Item(2,true,"this is my first item",R.id.imageItem));
               // Toast.makeText(getContext(),"Item:" + list.get(i), Toast.LENGTH_LONG).show();
            }
        });*/
        myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.remove(i);
                myAdapter.notifyDataSetChanged();
                return true;
            }
        });

        //adds movie item to the list
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    MovieItem movieItem = dataSnapshot.getValue(MovieItem.class);
                    list.add(movieItem);
                    myAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return root;
    }

}
