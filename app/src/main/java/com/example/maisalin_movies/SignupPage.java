package com.example.maisalin_movies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class SignupPage extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "FIREBASE";
    //declaring all the components
    private EditText editTextEmail, editTextPass,editTextName;
    private Button submit;
    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    private FirebaseAuth mAuth;
    boolean passwordVisible;

    private FirebaseAuth maFirebaseAuth=FirebaseAuth.getInstance();
    //write a message to the dataBase
    // gets the root of the real time database in the FB console
    private FirebaseDatabase database = FirebaseDatabase.getInstance("https://maisalin-movies-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        //Returns a reference to the instance of the project Firebase


        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPass= findViewById(R.id.editTextPass);
        submit=findViewById(R.id.editButton);
        submit.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

        //hide bar
        getSupportActionBar().hide();

        //hide/show password
        editTextPass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final  int Right=2;
                if(motionEvent.getAction()== MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX()>= editTextPass.getRight()-editTextPass.getCompoundDrawables()[Right].getBounds().width()){
                        int selection= editTextPass.getSelectionEnd();
                        if(passwordVisible){
                            //set drawable image here
                            editTextPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            //for hide password
                            editTextPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;

                        }else{
                            //set drawable image here
                            editTextPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            //for show password
                            editTextPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        editTextPass.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

    }



    public void signup(String email,String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            DatabaseReference myRef = database.getReference("profiles/"+user.getUid());//get Refrence returns a root
                            String key = myRef.push().getKey();
                            User u1 = new User(editTextName.getText().toString(),email,password);
                            u1.setKey(key);
                            myRef = database.getReference("profiles/"+user.getUid()+"/"+key);
                            myRef.setValue(u1);

                            Intent i =new Intent (SignupPage.this,MainActivity2.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignupPage.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view == submit) {
            signup(editTextEmail.getText().toString(), editTextPass.getText().toString());
        }
    }

    /*
    @Override
    public void onClick(View view) {

            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(SignupPage.this,
                    android.R.style.Theme_Holo_Dialog_MinWidth,
                    mOnDateSetListener,
                    year, month, day);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
    }*/

}