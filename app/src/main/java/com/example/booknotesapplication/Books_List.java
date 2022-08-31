package com.example.booknotesapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Books_List extends AppCompatActivity {

    ListView l;
    ArrayList<String> bookName = new ArrayList<>();
    Firestore fs = new Firestore(this);

    void LoadView() {
        Adapter adapter = new Adapter(bookName, Books_List.this);
        l.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);
        bookName.add("Think and Grow Rich");
        ListView listView = findViewById(R.id.book_list_view);
        Adapter adapter = new Adapter(bookName, Books_List.this);
        listView.setAdapter(adapter);
        Button add = findViewById(R.id.add_new_book_button);
        FloatingActionButton add_book = findViewById(R.id.add_book_button);
        add_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Books_List.this);
                v = LayoutInflater.from(Books_List.this).inflate(R.layout.fragment_add__books, null, false);
                builder.setView(v);
                Button add = v.findViewById(R.id.add_new_book_button);
                EditText Book_name = v.findViewById(R.id.Book_name);
                String book_name = Book_name.getText().toString().trim();
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v1) {
                        fs.Add(book_name,0);
                    //    bookName.add(Book_name.getText().toString());
                    //    Adapter adapterr = new Adapter(bookName, Books_List.this);
                     //   listView.setAdapter(adapterr);
                    }
                });
                builder.create().show();
                Toast.makeText(Books_List.this, "Hello there", Toast.LENGTH_SHORT).show();

            }
        });
    }
}