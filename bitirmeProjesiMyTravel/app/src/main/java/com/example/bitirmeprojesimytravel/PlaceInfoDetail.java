package com.example.bitirmeprojesimytravel;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class PlaceInfoDetail extends AppCompatActivity {

    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_info_detail);

        Intent i = getIntent();
        Place place = (Place) i.getSerializableExtra("DATA");  //DATA keyi ile tıkladığı datayı getiriyoruz
                                                                     //diğer ekrana data çekmek için serializeble ediyoruz

        ImageView ivDetail = findViewById(R.id.ivDetail);
        Picasso.get().load(place.detailPhoto).into(ivDetail);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = place.coordinate.split(",")[0];     //kordinatları x ve y deye değişken oluşturuyoruz virgül ile de split  ediyoruz
                String y = place.coordinate.split(",")[1];     //string değişkeni belli bir parametreye göre parçelera ayırı ve diziye koyar burada da 0. ve 1. elemanına getiriyoruz
                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?q=loc:%s,%s)", x, y); //uri adında string oluşturuyoruz ve %s , %s yi x ve y kordinatına getirip string yapıyoruz
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri)); // ve intent ile mapi açtırıyoruz // s koyamamızın amacı string değer görsün diye
                startActivity(intent);
            }
        });

        FloatingActionButton fabSound = findViewById(R.id.fabSound);
        fabSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAudio(place.sound);
            }
        });

    }

    private void playAudio(String soundUrl) {
        mediaPlayer = MediaPlayer.create(this,Uri.parse(soundUrl)); // sesi açıp kapatmamızı sağlar

        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }else{
            mediaPlayer.start();
        }
    }

}