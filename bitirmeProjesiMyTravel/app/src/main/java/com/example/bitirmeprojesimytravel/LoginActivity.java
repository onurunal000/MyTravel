package com.example.bitirmeprojesimytravel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {


        }

        Button btnGirisYap = findViewById(R.id.btnUyeOl);
        btnGirisYap.setOnClickListener(view -> authenticateUser());

    }

    private void authenticateUser() {
        EditText txtLoginEmail = findViewById(R.id.txtName);
        EditText txtLoginPassword = findViewById(R.id.txtPassword);

        String email = txtLoginEmail.getText().toString();
        String password = txtLoginPassword.getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(LoginActivity.this, task -> {      //firebasede kayıtlanmış email ve şifreyi bulup doğru olup olmadığına bakıyoruz
                    if (task.isSuccessful()) {
                        showHomeActivity();
                    } else {
                        Toast.makeText(LoginActivity.this, "Authentication failed.",   //eğer yoksa hata mesajı getirtiyoruz
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void showHomeActivity() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }

}

