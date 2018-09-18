package com.example.android.msgtoons;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.android.msgtoons.adapters.CustomListAdapter;

public class landing extends AppCompatActivity {

    ListView listView;
    String[] nameArray = {"KHANDESHI MOVIES","DSS Production","Khandesh Fun","Jkk Entertainment"};

    Integer[] imageArray = {R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four};

    String[] channel = {"UCP84QWij0alw4MvzqzyfOnw","UCeAYOWAX9YDOKgHLcOorB2g","UCt7QdU40U0PQegZCdH2yPjQ","UC5tuYcCdiKuF5Y2ZonuarwA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);


        CustomListAdapter whatever = new CustomListAdapter(this, nameArray, imageArray);
        listView = (ListView) findViewById(R.id.listviewID);
        listView.setAdapter(whatever);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(landing.this, MainActivity.class);
                String message = channel[position];
                intent.putExtra("channel", message);
                startActivity(intent);

            }
        });
    }

}
