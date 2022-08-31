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

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;

public class Books_List extends AppCompatActivity {

    ListView l;
    DatabaseReference databaseReference;

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
//        bookName.add("Think and Grow Rich");

        ListView listView = findViewById(R.id.book_list_view);
        fs.Read("Books").addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (DocumentSnapshot document : queryDocumentSnapshots) {
                    System.out.println(document.getId().toString());
                    System.out.println(document.get("Book Name").toString());
                    bookName.add(document.get("Book Name").toString());
                    Adapter adapter = new Adapter(bookName, Books_List.this);
                    listView.setAdapter(adapter);
                }

            }
        });


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
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v1) {
                        Firestore store = new Firestore(Books_List.this);
                        String book_name = Book_name.getText().toString().trim();
                        HashMap<String,Object> books = new HashMap<>();
                        books.put("Book Name",book_name);
                        Toast.makeText(Books_List.this, "Added", Toast.LENGTH_SHORT).show();
                        fs.Add("Books",books);
                        bookName.add(Book_name.getText().toString());
                        Adapter adapterr = new Adapter(bookName, Books_List.this);
                        listView.setAdapter(adapterr);
                    }
                });
                builder.create().show();
                Toast.makeText(Books_List.this, "Hello there", Toast.LENGTH_SHORT).show();

            }
        });
    }
}