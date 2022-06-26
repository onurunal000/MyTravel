package com.example.bitirmeprojesimytravel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PlacesListAdapter extends ArrayAdapter<Place> {

    private Activity context;
    private List<Place> placeList;

    public PlacesListAdapter(Activity context , List<Place> placeList) {
        super(context,R.layout.place_list_item,placeList);
        this.context=context;
        this.placeList=placeList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();              // girdi olarak xml dosyası alır görünümü oluşturur.
        View listViewItem = inflater.inflate(R.layout.place_list_item,null,true);

        ImageView ivPhoto = listViewItem.findViewById(R.id.ivPhoto);

        Place place = placeList.get(position);                  //place liste resimlerimiziyüklemmeizi sağlar
        Picasso.get().load(place.listPhoto).into(ivPhoto);

        listViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,PlaceInfoDetail.class);
                intent.putExtra("DATA",place);
                context.startActivity(intent);
            }
        });

        return listViewItem;

    }

}
