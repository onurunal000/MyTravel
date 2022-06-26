package com.example.bitirmeprojesimytravel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.List;

public class HotelListActivity extends AppCompatActivity {

    ListView lvHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);

        lvHotel = findViewById(R.id.lvHotel);

        Intent i = getIntent();
        List<Place> placeList = (List<Place>) i.getSerializableExtra("DATA"); // Listin ilk aktivitede doldurulması

        PlacesListAdapter adapter = new PlacesListAdapter( HotelListActivity.this,placeList);
        lvHotel.setAdapter(adapter); //listviewe ataması yapılır.



    }
}