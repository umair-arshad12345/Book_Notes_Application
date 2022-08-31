package com.example.booknotesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Content extends AppCompatActivity {
    Firestore fs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        Button save = findViewById(R.id.Save_button);

        Intent intent = getIntent();
        TextView bookNameContent = findViewById(R.id.Book_name_content);
//        bookNameContent.setText(intent.hasExtra("bookName"));
        bookNameContent.setText(intent.getStringExtra("bookName"));
        EditText book_content = findViewById(R.id.book_contents);
//        fs.filter("Books", "Book Name", book_data.get(position))
//        fs.Update("Books",);
        String bookContent = book_content.getText().toString();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Content.this,Books_List.class);
                startActivity(intent);
            }
        });

    }
}