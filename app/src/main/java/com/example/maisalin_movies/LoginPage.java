package com.example.maisalin_movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class LoginPage extends AppCompatActivity implements View.OnLongClickListener {

    //declaring all the components
    private EditText editTextName, editTextPass;
    private ImageView buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        // findViewById returns reference to the object with the specified id
        editTextName = findViewById(R.id.editTextName);
        editTextPass= findViewById(R.id.editTextPass);
        buttonLogin = findViewById(R.id.image_button);
        //sets the required button to response to long click, otherwise it won't
        buttonLogin.setOnLongClickListener(this);

        SharedPreferences sp = getSharedPreferences("settings",MODE_PRIVATE);
        String email=sp.getString("email","");
        String password = sp.getString("password","");

        if(!email.equals("") && !password.equals("")){
            editTextName.setText(email);
            editTextPass.setText(password);
        }

    }
    public void login(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        if (!editTextName.getText().toString().equals("")) {
            //saving email and password of user in local file for future use
            //create sp file
            SharedPreferences sp = getSharedPreferences("settings", MODE_PRIVATE);
            //open editor for editing
            SharedPreferences.Editor editor = sp.edit();
            //write the wanted settings
            editor.putString("email", editTextName.getText().toString());
            editor.putString("password", editTextPass.getText().toString());

            // save and close file
            editor.commit();


            intent.putExtra("name", editTextName.getText().toString());
            startActivity(intent);
        }
    }


    //clears the email and the password input on long click by user
    @Override
    public boolean onLongClick(View view) {
        editTextName.setText("");
        editTextPass.setText("");

        return true;
    }
}