package com.example.maisalin_movies;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileNotFoundException;

public class ProfileFragment extends Fragment implements View.OnClickListener{

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView userName;
    private TextView password;
    private TextView email;

    private MaterialCardView cardGallery,cardCamera;
    private ImageView profilepic;
    //gallery and camera
    private static final int GALLERY_REQUEST = 1;
    private static final int CAMERA_REQUEST = 0;
    //for picture of camera
    private Bitmap picture;

    private FirebaseDatabase database = FirebaseDatabase.getInstance("https://maisalin-movies-default-rtdb.firebaseio.com/");
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = mAuth.getCurrentUser();


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment profileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    private void updateUserData(User user) {
        userName.setText(user.getUserName());
        email.setText(user.getEmail());
        password.setText(user.getPassword());
        //   location.setText(user.getAdress());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);



        userName=rootView.findViewById(R.id.editTextNameProfile);
        email=rootView.findViewById(R.id.editTextEmailAddressProfile);
        password=rootView.findViewById(R.id.editTextPasswordProfile);
        cardCamera=rootView.findViewById(R.id.cardCamera);
        cardCamera.setOnClickListener(this);

        cardGallery =rootView.findViewById(R.id.cardGallery);
        cardGallery.setOnClickListener(this);

        profilepic=rootView.findViewById(R.id.profilePic);

        DatabaseReference myRef = database.getReference("profiles/"+user.getUid());//get reference that returns a root
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()) {
                    User u = dataSnapshot.getValue(User.class);
                    //
                    Log.i("Profile1111", "user" + u + " Id " + user.getUid() + " u" + u.getUserName() + u.getEmail() + u.getPassword());
                    updateUserData(new User(u.getUserName(), u.getEmail(), u.getPassword()));
                }
            }

            //gets reference for the design components

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                 Log.w("profile", "Failed to read value.", error.toException());
            }
        });


        return rootView;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.cardCamera){
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i, CAMERA_REQUEST);
        }else if(view.getId() == R.id.cardGallery){
            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, GALLERY_REQUEST);
        }}
        @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_REQUEST){
            //RESULT_OK --> the camera managed to take a picture
            if(resultCode == RESULT_OK){
                picture = (Bitmap) data.getExtras().get("data");
                //set image captured to be the new image
                profilepic.setImageBitmap(picture);
            }
        }
        else
        {
            if(resultCode == RESULT_OK){
                Uri targetUri = data.getData();//the file location
                try{
                    //Decode an input stream into bitmap
                    picture = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(targetUri));
                    profilepic.setImageBitmap(picture);
                }
                //catch - don't kill the application if the file didn't open --> print the error
                catch(FileNotFoundException e){
                    e.printStackTrace();
                }
            }
        }

    }

}