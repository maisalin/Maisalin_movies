package com.example.maisalin_movies;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    @Nullable
    private CardView popular1,popular2 ,popular3, movie01,movie02,movie04;
    private RelativeLayout tvShowCard, popularCard, moviesCard, tvShows2Card, romComsCard;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.activity_main,container,false);

       /* View rootView = inflater.inflate(R.layout.activity_main, container, false);
        popularCard =rootView.findViewById(R.id.popular1);
        popularCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getActivity(),DetailActivity.class);
                i.putExtra("name","Divergent");
                startActivity(i);
            }
        });
        return rootView;*/

        View v= inflater.inflate(R.layout.activity_main,container, false);
        popular1=(CardView) v.findViewById(R.id.popular1);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        popular1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "Divergent");
                startActivity(i);
            }
        });
    }
}
