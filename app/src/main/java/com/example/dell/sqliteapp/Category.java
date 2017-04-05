package com.example.dell.sqliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Category extends AppCompatActivity {
    TextView cat1 ,cat2 ;
    DatabaseHelper myDb;
    Button menu ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        myDb = new DatabaseHelper(this);
        cat1 = (TextView)findViewById(R.id.cat1);
        cat2 = (TextView)findViewById(R.id.cat2);
        cat1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent j = new Intent(Category.this,First.class);
                startActivity(j);
            }
        });
        cat2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent k = new Intent(Category.this,Second.class);

                startActivity(k);
            }
        });
        menu = (Button)findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent k = new Intent(Category.this,MainActivity.class);
                startActivity(k);
            }
        });


    }
}
