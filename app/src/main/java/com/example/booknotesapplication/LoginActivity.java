package com.example.booknotesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Editable email;
    private Editable password;
    firebase fb = new firebase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView Signup_text= findViewById(R.id.Signup_activity);
        Button Login_button = findViewById(R.id.Login_button);
        EditText Email_text = findViewById(R.id.email_login);
        String email = Email_text.getText().toString();
        EditText Password_text = findViewById(R.id.password_login);
        String password = Password_text.getText().toString();
        Signup_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,register_Activity.class);
                startActivity(intent);
            }

        });

        Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email_text.getText().toString();
                String password = Password_text.getText().toString();
                if (email.isEmpty() && password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please Enter Email and Password", Toast.LENGTH_SHORT).show();
                }
                else{
                    fb.Login(email, password);
                    Toast.makeText(LoginActivity.this, "Loginn", Toast.LENGTH_SHORT).show();
                }
              //  Intent intent=new Intent(LoginActivity.this,Books_List.class);
              //  startActivity(intent);
            }
        });


        }

}