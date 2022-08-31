package com.example.booknotesapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    ArrayList<String> book_data;
    LayoutInflater inflater;
    Context context;


    public Adapter(ArrayList<String>  book_data, Context context) {
        this.book_data = book_data;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return book_data.size();
    }

    @Override
    public Object getItem(int position) {
        return book_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_book_listview, null);
        TextView book_name = convertView.findViewById(R.id.Book_name);
        book_name.setText(book_data.get(position));
        ImageView edit = convertView.findViewById(R.id.Edit_button);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, String.valueOf(position), Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,Content.class);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
