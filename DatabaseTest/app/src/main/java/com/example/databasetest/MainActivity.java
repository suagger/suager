package com.example.databasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String newId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addDate = findViewById(R.id.add_data);
        addDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("content://com.example.databasetest.provider/book");
                ContentValues values = new ContentValues();
                values.put("name","A Clash of King");
                values.put("author","George Maritin");
                values.put("pages",1040);
                values.put("price",22.85);
                Uri newUri = getContentResolver().insert(uri,values);
                newId = newUri.getPathSegments().get(1);
            }
        });
        Button updateData = findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Uri uri = Uri.parse("content://com.example.databasetest.provider/book" + newId);
                 ContentValues values = new ContentValues();
                 values.put("name","A Storm of Swords");
                 values.put("pages",1216);
                 values.put("price",24.05);
                 values.put("price",24.05);
                 getContentResolver().update(uri,values,null,null);
            }
        });
        Button deleteButton = findViewById(R.id.delete_data);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("content://com.example.databasetest.provider/book/" + newId);
                getContentResolver().delete(uri,null,null);
            }
        });
        Button queryButton = findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Uri uri = Uri.parse("content://com.example.databasetest.provider/book");
                  Cursor cursor = getContentResolver().query(uri,null,null,null,null);
                  if(cursor != null) {
                      while(cursor.moveToNext()) {
                          String name = cursor.getString(cursor.getColumnIndex("name"));
                          String author = cursor.getString(cursor.getColumnIndex("author"));
                          int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                          double price = cursor.getDouble(cursor.getColumnIndex("price"));
                          Log.d("MainActivity","book name is " + name);
                          Log.d("MainActivity","book author is " + author);
                          Log.d("MainActivity","book pages is " + pages);
                          Log.d("MainActivity","book price is " + price);
                      }
                      cursor.close();
                }
            }
        });
    }
}
