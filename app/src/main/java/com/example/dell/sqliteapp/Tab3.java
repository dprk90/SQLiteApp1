package com.example.dell.sqliteapp;

import android.database.Cursor;
import android.content.Intent;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class Tab3 extends Fragment {
    ListView lv3 ;
    DatabaseHelper myDb;
    MyListAdapter adapter ;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3, container, false);
        myDb = new DatabaseHelper(getContext());
        Cursor res = myDb.getAllData();

        int i = 0 ;
        res.moveToFirst();
        while(res.moveToNext() && i<100)
        {
            if(res.getInt(4)==1 && res.getInt(5)==3)
            {
                ++i ;

            }
        }

        String[] n = new String[i] ;
        int[] p = new int[i] ;
        int[] q = new int[i] ;
        i = 0 ;

        res.moveToFirst();
        while(res.moveToNext() && i<100)
        {
            if(res.getInt(4)==1 && res.getInt(5)==3)
            {
                n[i] = res.getString(1);
                p[i] = res.getInt(2);
                q[i] = res.getInt(3);
                ++i ;

            }
        }

        adapter = new MyListAdapter(getActivity(),n,q,p);
        lv3 = (ListView)rootView.findViewById(R.id.lv3);
        lv3.setAdapter(adapter);
        return rootView;
    }

}

