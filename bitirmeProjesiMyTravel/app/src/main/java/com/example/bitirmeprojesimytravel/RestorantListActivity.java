package com.example.bitirmeprojesimytravel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.List;

public class RestorantListActivity extends AppCompatActivity {

    ListView lvRestaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restorant_list);

        lvRestaurant = findViewById(R.id.lvRestaurant);

        Intent i = getIntent();
        List<Place> placeList = (List<Place>) i.getSerializableExtra("DATA"); //home ekranından type 1 olan getirmek için yazdık ve data adında aralarında şifre oluşturduk

        PlacesListAdapter adapter = new PlacesListAdapter(RestorantListActivity.this,placeList);
        lvRestaurant.setAdapter(adapter);

    }
}