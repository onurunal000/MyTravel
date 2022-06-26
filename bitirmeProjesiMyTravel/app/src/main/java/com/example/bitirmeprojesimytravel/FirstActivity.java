package com.example.bitirmeprojesimytravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button  btnUyeOl = findViewById(R.id.btnUyeOl);
        Button btnGirisYap = findViewById(R.id.btnGirisYap);

        btnGirisYap.setOnClickListener(view -> {
            startActivity(new Intent(FirstActivity.this,LoginActivity.class));
        });
        btnUyeOl.setOnClickListener(view -> {
            startActivity(new Intent(FirstActivity.this,RegisterActivity.class));
        });
    }

}