package com.example.e_agricmarketing;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDisplay extends AppCompatActivity {
    private String telephoneNum;
    TextView textView1, textView2, textView3, textView4, textView5;
    Button callSeller, sendSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_display);

        Intent intent = getIntent();
        String addDescription = intent.getStringExtra("DESCRIPTION");
        telephoneNum = intent.getStringExtra("TELEPHONE");
        String heading = intent.getStringExtra("HEADING");
        String address = intent.getStringExtra("ADDRESS");
        String type = intent.getStringExtra("TYPE");

        textView1 = findViewById(R.id.heading);
        textView2 = findViewById(R.id.description);
        textView3 = findViewById(R.id.type);
        textView4 = findViewById(R.id.address);
        textView5 = findViewById(R.id.telephonenum); // Updated to match the XML layout
        callSeller = findViewById(R.id.callSeller);
        sendSMS = findViewById(R.id.sendSMS);

        textView1.setText(heading);
        textView2.setText(addDescription);
        textView3.setText(type);
        textView5.setText(telephoneNum); // Updated to match the XML layout
        textView4.setText(address);

        callSeller.setOnClickListener(v -> call(telephoneNum));

        sendSMS.setOnClickListener(v -> send(telephoneNum));
    }

    private void send(String telephoneNum) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + telephoneNum));
        startActivity(intent);
    }

    private void call(String telephoneNum) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + telephoneNum));
        startActivity(intent);
    }
}
