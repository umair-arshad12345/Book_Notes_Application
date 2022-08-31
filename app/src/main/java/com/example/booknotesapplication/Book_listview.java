package com.example.booknotesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class Book_listview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_listview);
        ListView l = findViewById(R.id.book_list_view);
        ImageView Edit_button = findViewById(R.id.Edit_button);
        LayoutInflater inflater = LayoutInflater.from(this);
        Button add = findViewById(R.id.add_new_book_button);

        Edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView edit = l.findViewById(R.id.Edit_button);
                Intent intent = new Intent(Book_listview.this,Content.class);
                startActivity(intent);
                Toast.makeText(Book_listview.this, "Started", Toast.LENGTH_SHORT).show();
            }
        });


    }


}