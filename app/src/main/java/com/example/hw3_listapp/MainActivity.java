package com.example.hw3_listapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView myrecyclerView;
    String[] items;
    String[] prices;
    String[] descriptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        myrecyclerView = (RecyclerView) findViewById(R.id.myrecyclerView);
        items = res.getStringArray(R.array.items);
        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.descriptions);

        ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, descriptions);
        RecyclerView.setAdapter(itemAdapter);

        myrecyclerView.setOnLongClickListener(new AdapterView.onLongClickListener(){
            @Override
            public void onLongClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent showDetailActivity = new Intent(getApplicationContext(), Detail_Activity.class);
                showDetailActivity.putExtra("com.example.ITEM_INDEX" ,i);
                startActivity(showDetailActivity);
            }
        });

    }
}