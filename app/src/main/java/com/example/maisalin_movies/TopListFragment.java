package com.example.maisalin_movies;

import android.content.Context;
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

public class TopListFragment extends Fragment {

    //the object of the view - design
    private ListView myListView;
    //object containing the items to be displayed - Data
    private ArrayList<MovieItem> list;
    //the object for the adapter connecting the data to the view
    private MovieAdapter myAdapter;
    //get instance of authentication project in FB console
    private FirebaseAuth maFirebaseAuth = FirebaseAuth.getInstance();
    //gets the root of the real time database in the FB console
    private FirebaseDatabase database = FirebaseDatabase.getInstance("https://maisalin-movies-default-rtdb.firebaseio.com/");

   // public  static int count =0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.toplist_fragment, container, false);

        Context context= getContext();

        String UID = maFirebaseAuth.getUid();
        //Toast.makeText(context, "UID:" + UID, Toast.LENGTH_LONG).show();
        //build reference fo user related data in real time database suing user ID
        DatabaseReference myRef = database.getReference("top_movies/" + UID + "/top_movies");

        list = new ArrayList<>();


       // if(count==0){
        list.add(new MovieItem(R.drawable.bridgerton, "bridgerton","1","0"));
        list.add(new MovieItem(R.drawable.lucifer, "lucifer","2","0"));
        list.add(new MovieItem(R.drawable.tv4 ,"money heist","3","0"));
        list.add(new MovieItem(R.drawable.thegood,"The good doctor","4","0"));
        list.add(new MovieItem(R.drawable.the100,"the 100","5","0"));
        list.add(new MovieItem(R.drawable.suits,"Suits","6","0"));
        list.add(new MovieItem(R.drawable.twi,"Twilight","7","0"));
        list.add(new MovieItem(R.drawable.thenb,"The notebook","8","0"));
        list.add(new MovieItem(R.drawable.m12,"Friends with benefits","9","0"));
        list.add(new MovieItem(R.drawable.nerve,"Nerve","10","0"));
        //    count++;
        //}




        /*database.getReference("top_movies/" + UID + "/top_movies").push().setValue(new MovieItem(R.drawable.bridgerton, "bridgerton","1","0"));
        database.getReference("top_movies/" + UID + "/top_movies").push().setValue(new MovieItem(R.drawable.lucifer, "lucifer","2","0"));
        database.getReference("top_movies/" + UID + "/top_movies").push().setValue(new MovieItem(R.drawable.tv4 ,"money heist","3","0"));
        database.getReference("top_movies/" + UID + "/top_movies").push().setValue(new MovieItem(R.drawable.thegood,"The good doctor","4","0"));
        database.getReference("top_movies/" + UID + "/top_movies").push().setValue(new MovieItem(R.drawable.the100,"the 100","5","0"));
        database.getReference("top_movies/" + UID + "/top_movies").push().setValue(new MovieItem(R.drawable.suits,"Suits","6","0"));
        database.getReference("top_movies/" + UID + "/top_movies").push().setValue(new MovieItem(R.drawable.twi,"Twilight","7","0"));
        database.getReference("top_movies/" + UID + "/top_movies").push().setValue(new MovieItem(R.drawable.thenb,"The notebook","8","0"));
        database.getReference("top_movies/" + UID + "/top_movies").push().setValue(new MovieItem(R.drawable.m12,"Friends with benefits","9","0"));
        database.getReference("top_movies/" + UID + "/top_movies").push().setValue(new MovieItem(R.drawable.nerve,"Nerve","10","0"));
*/
        //reference to the list view so it can be programmed
        myListView = v.findViewById(R.id.myListView);

        //connect adapter with data
        myAdapter = new MovieAdapter(context, R.layout.item, list);

        //connect adapter with view
        myListView.setAdapter(myAdapter);
        //connects click listener to items in the list
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //myRef.push().setValue(new Item(2,true,"this is my first item",R.id.imageItem));
               // Toast.makeText(context,"Item:" + list.get(i), Toast.LENGTH_LONG).show();
            }
        });
        myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.remove(i);
                myAdapter.notifyDataSetChanged();
                return false;
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    MovieItem item1 = dataSnapshot.getValue((MovieItem.class));
                    list.add(item1);
                    myAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return v;
    }


}
