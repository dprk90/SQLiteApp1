package com.example.dell.sqliteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb ;
    TextView newOrders ;
    TextView ordersPlaced ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        if(myDb.QueryNumEntries()<101)
        {
            for(int i=1;i<101;++i)
            {
                int price = (int)(Math.random()*100 + 1);
                int cat = (int)(Math.random()*2+1);
                int subcat = (int)(Math.random()*3+1);
                myDb.insertData("A"+i,price,0,cat,subcat);

            }
        }


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
                startActivity(t);
            }
        });




    }
}

