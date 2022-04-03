package com.example.maisalin_movies;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class TopFragment extends Fragment {
    @Nullable
    private CardView top1,top2,top3,top4,top5,top6,top7,top8,top9,top10;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_top, container, false);
        top1 = (CardView) v.findViewById(R.id.top1);
        top2 = (CardView) v.findViewById(R.id.top2);
        top3 = (CardView) v.findViewById(R.id.top3);
        top4 = (CardView) v.findViewById(R.id.top4);
        top5 = (CardView) v.findViewById(R.id.top5);
        top6 = (CardView) v.findViewById(R.id.top6);
        top7 = (CardView) v.findViewById(R.id.top7);
        top8 = (CardView) v.findViewById(R.id.top8);
        top9 = (CardView) v.findViewById(R.id.top9);
        top10 = (CardView) v.findViewById(R.id.top10);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        top1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "Divergent");
                startActivity(i);
            }
        });
        top2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "LaCasa");
                startActivity(i);
            }
        });
        top3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "");
                startActivity(i);
            }
        });
        top4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "");
                startActivity(i);
            }
        });
        top5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "");
                startActivity(i);
            }
        });
        top6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "");
                startActivity(i);
            }
        });
        top7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "");
                startActivity(i);
            }
        });
        top8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "");
                startActivity(i);
            }
        });
        top9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "");
                startActivity(i);
            }
        });
        top10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "");
                startActivity(i);
            }
        });
    }
}
