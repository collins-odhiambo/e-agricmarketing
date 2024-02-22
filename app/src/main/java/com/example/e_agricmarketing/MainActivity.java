package com.example.e_agricmarketing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signUpButton = (Button) findViewById(R.id.signup);
        Button loginButton = (Button) findViewById(R.id.loginin);

        signUpButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this , Login.class);
            startActivity(intent);

        });
        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this , signing.class);
            startActivity(intent);

        });
    }


}
