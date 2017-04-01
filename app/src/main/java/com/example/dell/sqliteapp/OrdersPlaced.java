package com.example.dell.sqliteapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OrdersPlaced extends AppCompatActivity {
    TextView tv ;
    String a;
    DatabaseHelper myDb ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_placed);
        myDb = new DatabaseHelper(this);
        Cursor res = myDb.getAllData();
        Intent t = getIntent();
        a = t.getStringExtra("a");

        res.moveToPosition(3);
        int q = res.getInt(3);

        tv = (TextView)findViewById(R.id.textView);
        tv.setText(Integer.toString(q));
    }
}
