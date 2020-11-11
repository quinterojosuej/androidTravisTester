package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button submit;
    Intent intent;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = Factory.makeUser();

        intent = new Intent(getApplicationContext(), MainActivity.class);

        username = findViewById(R.id.userInput);
        password = findViewById(R.id.passInput);
        submit = findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean nameFlag = Factory.checkUsername(user, username.getText().toString());
                boolean passFlag = Factory.checkPassword(user, password.getText().toString());
                boolean masterFlag = nameFlag && passFlag;
                if(masterFlag)
                {
                    intent.putExtra("currentUser", username.getText().toString());
                    Context c = getApplicationContext();
                    startActivity(intent);
                }
                //Change line color from: @degs https://stackoverflow.com/questions/40838069/programmatically-changing-underline-color-of-edittext
                ColorStateList csl = ColorStateList.valueOf(Color.RED);

                if(!nameFlag){
                    username.setError("Username not found!");
                    username.setBackgroundTintList(csl);
                    password.setBackgroundTintList(csl);
                }

                else if(!passFlag){
                    password.setError("Incorrect password");
                    password.setBackgroundTintList(csl);
                }
//
//                int duration = Toast.LENGTH_LONG;
//
//                Toast.makeText(c, username.getText() + " " + password.getText(), duration).show();
//                startActivity(intent);
            }
        });
    }
}
