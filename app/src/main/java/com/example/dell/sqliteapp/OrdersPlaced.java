package com.example.dell.sqliteapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import static com.example.dell.sqliteapp.R.id.q;

public class OrdersPlaced extends AppCompatActivity {
    DatabaseHelper myDb ;
    Cursor res ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_placed);



        LinearLayout lli = (LinearLayout)findViewById(R.id.lli);
        TextView total = (TextView)findViewById(R.id.total);

        myDb = new DatabaseHelper(getApplicationContext());
        res = myDb.getAllData();

        int c = 0 ;
        for(int idx=0;idx<100;++idx)
        {
            res.moveToPosition(idx);

            if(res.getInt(3)!=0)
            {
                c = c + res.getInt(3)*res.getInt(2) ;
                TextView tt = new TextView(this);
                tt.setTextSize(25);
                tt.setText("  " + res.getString(1) + "          " + Integer.toString(res.getInt(2)) + "          " + Integer.toString(res.getInt(3)));
                lli.addView(tt);
            }
        }
        total.setTextSize(40);
        total.setText(" Total : Rs. " + Integer.toString(c) + "/-");

        for (int i=1;i<101;++i)
        {
            myDb.reset(Integer.toString(i),0);
        }


    }
}
