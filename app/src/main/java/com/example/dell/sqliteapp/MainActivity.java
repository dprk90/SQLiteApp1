package com.example.dell.sqliteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb ;
    TextView newOrders ;
    TextView ordersPlaced ;
    String[] n ;
    int[] q ;
    int[] p ;
    String a ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        newOrders = (TextView) findViewById(R.id.button1);
        ordersPlaced = (TextView) findViewById(R.id.button2);

        newOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Category.class);
                startActivity(i);
            }
        });

        ordersPlaced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(MainActivity.this,OrdersPlaced.class);
                t.putExtra("a","yes");
                startActivity(t);
            }
        });




    }
}

