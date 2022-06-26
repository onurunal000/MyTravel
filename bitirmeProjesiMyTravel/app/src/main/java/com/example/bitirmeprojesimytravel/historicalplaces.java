package com.example.bitirmeprojesimytravel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.List;

public class historicalplaces extends AppCompatActivity {

    ListView lvPlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historicalplaces);

        lvPlaces = findViewById(R.id.lvPlaces);

        Intent i = getIntent();
        List<Place> placeList = (List<Place>) i.getSerializableExtra("DATA");  //home ekranında

        PlacesListAdapter adapter = new PlacesListAdapter(historicalplaces.this,placeList);
        lvPlaces.setAdapter(adapter);

    }
}