package com.example.dell.sqliteapp;

import android.database.Cursor;
import android.content.Intent;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class Tab1 extends Fragment {
    ListView lv1 ;
    DatabaseHelper myDb;
    MyListAdapter adapter ;
    Cursor res ;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1, container, false);
        myDb = new DatabaseHelper(getContext());
        res = myDb.getAllData();

        int i = 0 ;
        res.moveToFirst();
        while(res.moveToNext() && i<100)
        {
            if(res.getInt(4)==1 && res.getInt(5)==1)
            {
                ++i ;


            }
        }
        Log.e("count of items",""+i);
        int[] p = new int[i] ;
        int[] q = new int[i] ;

        String[] n = new String[i] ;
        i = 0 ;


        res.moveToFirst();
        while(res.moveToNext())
        {
            if(res.getInt(4)==1 && res.getInt(5)==1 && i<100)
            {
                n[i] = res.getString(1);
                p[i] = res.getInt(2);
                q[i] = res.getInt(3);
                ++i ;

            }
        }

        adapter = new MyListAdapter(getActivity(),n,q,p);
        lv1 = (ListView)rootView.findViewById(R.id.lv1);
        lv1.setAdapter(adapter);

        return rootView;
    }

}

