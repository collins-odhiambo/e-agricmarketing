package com.example.e_agricmarketing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MyAccount extends AppCompatActivity {
    private EditText username, telephone, password;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        Intent intent = getIntent();
        String message = intent.getStringExtra("USERNAME");
        System.out.println("DOne");
        username = (EditText) findViewById(R.id.username);
        telephone = (EditText) findViewById(R.id.telephonenum);
        password = (EditText) findViewById(R.id.password);
        Button update = (Button) findViewById(R.id.createAdd);

        user = new User(this, null,1);
        String[] mydetails =user.getMyDetails(message);
        String username1 = mydetails[0];
        String password1 = mydetails[1];
        String telephone1 = mydetails[2];

        username.setText(username1);
        telephone.setText(telephone1);
        password.setText(password1);

        update.setOnClickListener(v -> updateDetails());
    }

    private void updateDetails() {
        try {
            user.updateDetails(username.getText().toString(), password.getText().toString(),telephone.getText().toString());
            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(this, "Updated" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
