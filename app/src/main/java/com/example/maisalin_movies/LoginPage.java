package com.example.maisalin_movies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class LoginPage extends AppCompatActivity implements View.OnLongClickListener, View.OnClickListener {


    private static final String TAG ="FIREBASE" ;
    //declaring all the components
    private EditText editTextName, editTextPass;
    private Button buttonLogin;
    private FirebaseAuth mAuth;
    boolean passwordVisible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        //Returns a reference to the instance of the project Firebase
        mAuth = FirebaseAuth.getInstance();

        //hide bar
        getSupportActionBar().hide();

        // findViewById returns reference to the object with the specified id
        editTextName = findViewById(R.id.editTextName);
        editTextPass= findViewById(R.id.editTextPass);
        buttonLogin = findViewById(R.id.editButton);


        //sets the required button to response to long click, otherwise it won't
        buttonLogin.setOnLongClickListener(this);
        buttonLogin.setOnClickListener(this);

        SharedPreferences sp = getSharedPreferences("settings",MODE_PRIVATE);
        String email=sp.getString("email","");
        String password = sp.getString("password","");

        if(!email.equals("") && !password.equals("")){
            editTextName.setText(email);
            editTextPass.setText(password);
        }

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

    public void signup(View view){
        Intent intent = new Intent(this, SignupPage.class);
        startActivity(intent);
    }


    //clears the email and the password input on long click by user
    @Override
    public boolean onLongClick(View view) {
        editTextName.setText("");
        editTextPass.setText("");

        return true;
    }

    public void login(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(LoginPage.this,MainActivity2.class);
                            startActivity(i);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginPage.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    @Override
    public void onClick(View view) {
        login(editTextName.getText().toString(), editTextPass.getText().toString());
    }
}