package com.example.booknotesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebase fb = new firebase(this);
        EditText Email_text = findViewById(R.id.email);
        EditText Password_text = findViewById(R.id.editTextTextPassword);
        String email = Email_text.toString().trim();
        String password = Password_text.toString().trim();
        TextView Login_activity = findViewById(R.id.Login_Activity);
        Button signup_button = findViewById(R.id.signupbutton);
        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email_text.getText().toString();
                String password = Password_text.getText().toString();
                if (email.isEmpty() && password.isEmpty()){
                    Toast.makeText(register_Activity.this, "Not Valid", Toast.LENGTH_SHORT).show();
                }
                else{
                    fb.Signup(email, password);
                    Toast.makeText(register_Activity.this, "Registerr", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Login_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    }
