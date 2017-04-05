package com.example.dell.sqliteapp;


import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.id;
import static com.example.dell.sqliteapp.DatabaseHelper.COL_3;
import static com.example.dell.sqliteapp.DatabaseHelper.COL_4;
import static com.example.dell.sqliteapp.DatabaseHelper.TABLE_NAME;

public class MyListAdapter extends ArrayAdapter<String>
{
    DatabaseHelper myDb  = new DatabaseHelper(getContext());
    private final Activity context ;
    private final String[] progNames ;
    private final int[] quantity ;
    private final int[] prices ;
    Cursor res ;


    public MyListAdapter(Activity context, String[] progNames, int[] quantity, int[] prices )
    {
        super(context,R.layout.item_list,progNames);
        this.context = context;
        this.progNames = progNames;
        this.quantity = quantity ;
        this.prices = prices ;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_list,null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.name);
        txtTitle.setText(progNames[position]);

        TextView price = (TextView) rowView.findViewById(R.id.price);
        price.setText("Rs. "+Integer.toString(prices[position]));

        final TextView q = (TextView)rowView.findViewById(R.id.q) ;
        q.setText(Integer.toString(quantity[position]));

        Button b1 = (Button)rowView.findViewById(R.id.b1);
        Button b2 = (Button)rowView.findViewById(R.id.b2);

        res = myDb.getAllData();



        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(quantity[position]>0)
                {
                    --quantity[position] ;
                }
                q.setText(Integer.toString(quantity[position]));
                int c = 0;

                res.moveToFirst();
                while(res.moveToNext())
                {
                    if(res.getString(1).equals(progNames[position]))
                    {
                        boolean up = myDb.updateData(Integer.toString(2+c),progNames[position],  prices[position], quantity[position]);
                    }
                    ++c ;
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ++quantity[position] ;
                q.setText(Integer.toString(quantity[position]));
                res.moveToFirst();
                int c = 0 ;
                while(res.moveToNext() && c<100)
                {
                    if(res.getString(1).equals(progNames[position]))
                    {
                        boolean up = myDb.updateData(Integer.toString(c+2),progNames[position],  prices[position], quantity[position]);
                    }
                    ++c ;
                }

            }
        });
        return rowView ;
    }
}
