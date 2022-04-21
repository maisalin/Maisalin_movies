package com.example.maisalin_movies;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    @Nullable
    private CardView popular1,popular2 ,popular3,popular4,popular5,movie01,movie02,movie04,movie03,
            tvShow1,tvShow2,tvShow3,tvShow4,tvShow5,tvShow6,tvShow7,tv1,tv2,tv3,tv4,tv5,tv6,
            romCom1,romCom2,romCom3,romCom4,romCom5,romCom6;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_home,container, false);
        popular1=(CardView) v.findViewById(R.id.popular1);
        popular2=(CardView) v.findViewById(R.id.popular2);
        popular3=(CardView) v.findViewById(R.id.popular3);
        popular4=(CardView) v.findViewById(R.id.popular4);
        popular5=(CardView) v.findViewById(R.id.popular5);
        movie01=(CardView) v.findViewById(R.id.movie01);
        movie02=(CardView) v.findViewById(R.id.movie02);
        movie03=(CardView) v.findViewById(R.id.movie03);
        movie04=(CardView) v.findViewById(R.id.movie04);
        tvShow1=(CardView) v.findViewById(R.id.tvShow1);
        tvShow2=(CardView) v.findViewById(R.id.tvShow2);
        tvShow3=(CardView) v.findViewById(R.id.tvShow3);
        tvShow4=(CardView) v.findViewById(R.id.tvShow4);
        tvShow5=(CardView) v.findViewById(R.id.tvShow5);
        tvShow6=(CardView) v.findViewById(R.id.tvShow6);
        tvShow7=(CardView) v.findViewById(R.id.tvShow7);
        tv1=(CardView) v.findViewById(R.id.tv21);
        tv2=(CardView) v.findViewById(R.id.tv22);
        tv3=(CardView) v.findViewById(R.id.tv23);
        tv4=(CardView) v.findViewById(R.id.tv24);
        tv5=(CardView) v.findViewById(R.id.tv25);
        tv6=(CardView) v.findViewById(R.id.tv26);
        romCom1= (CardView) v.findViewById(R.id.romcom1);
        romCom2= (CardView) v.findViewById(R.id.romcom2);
        romCom3= (CardView) v.findViewById(R.id.romcom3);
        romCom4= (CardView) v.findViewById(R.id.romcom4);
        romCom5= (CardView) v.findViewById(R.id.romcom5);
        romCom6= (CardView) v.findViewById(R.id.romcom6);

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
        popular2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "LaCasa");
                startActivity(i);
            }
        });
        popular3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "Under");
                startActivity(i);
            }
        });
        popular4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "Vampire");
                startActivity(i);
            }
        });
        popular5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "Shadow");
                startActivity(i);
            }
        });
        movie01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "Divergent");
                startActivity(i);
            }
        });
        movie02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "Fallen");
                startActivity(i);
            }
        });
        movie03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "Before");
                startActivity(i);
            }
        });
        movie04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "After");
                startActivity(i);
            }
        });
        tvShow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "ToyBoy");
                startActivity(i);
            }
        });
        tvShow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "You");
                startActivity(i);
            }
        });
        tvShow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "Elite");
                startActivity(i);
            }
        });
        tvShow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "TheSociety");
                startActivity(i);
            }
        });
        tvShow5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "Lost");
                startActivity(i);
            }
        });
        tvShow6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "LaCasa");
                startActivity(i);
            }
        });
        tvShow7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "Reasons");
                startActivity(i);
            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "Ghost");
                startActivity(i);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "SpiderMan");
                startActivity(i);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "Arrow");
                startActivity(i);
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "TeenWolf");
                startActivity(i);
            }
        });
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "Prison");
                startActivity(i);
            }
        });
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "Obx");
                startActivity(i);
            }
        });
        romCom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "Summer");
                startActivity(i);
            }
        });
        romCom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "FriendsW");
                startActivity(i);
            }
        });
        romCom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "Holidate");
                startActivity(i);
            }
        });
        romCom4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "GoWith");
                startActivity(i);
            }
        });
        romCom5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "ToAll");
                startActivity(i);
            }
        });
        romCom6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "Love");
                startActivity(i);
            }
        });
    }
}


