package com.example.e_agricmarketing;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddAdvertisement extends AppCompatActivity {

    private EditText heading, address, description, telephoneNum, type;
    private Advertisement advertisement;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_advertisement);
        Intent intent = getIntent();
        message = intent.getStringExtra("USERNAME");

        heading = (EditText)findViewById(R.id.heading);
        address = (EditText)findViewById(R.id.address);
        description = (EditText)findViewById(R.id.description);
        telephoneNum = (EditText)findViewById(R.id.telephonenum);
        type = (EditText)findViewById(R.id.type);
        ImageButton location = (ImageButton) findViewById(R.id.addlocation);
        Button create = (Button) findViewById(R.id.createAdd);
        advertisement = new Advertisement(this, null,1);
        create.setOnClickListener(v -> createAdd());
        location.setOnClickListener(v -> getLocation());
    }

    private void getLocation() {


    }

    public void createAdd(){
        String heading1 = heading.getText().toString();
        String address1 = address.getText().toString();
        String description1 = description.getText().toString();
        String telephoneNum1 = telephoneNum.getText().toString();
        String type1 = type.getText().toString();


        if(TextUtils.isEmpty(heading1)){
            Toast.makeText(this, "Please enter the heading", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(address1)){
            Toast.makeText(this, "Please enter your address", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(description1)){
            Toast.makeText(this, "Please enter your description", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(telephoneNum1)){
            Toast.makeText(this, "Please enter your telephoneNum", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(type1)){
            Toast.makeText(this, "Please enter your type", Toast.LENGTH_SHORT).show();
        }
        else{
                /*loadingBar.setTitle("Create Account");
                loadingBar.setMessage("Please Wait we are processing");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();*/

            try{
                advertisement.setHeading(heading1);
                advertisement.setAddDescription(description1);
                advertisement.setAddress(address1);
                advertisement.setTelephoneNum(telephoneNum1);
                advertisement.setType(type1);
                advertisement.setUsername(message);
                advertisement.addAdvertisement();

                Toast.makeText(this, "Advertisement Created Successfully", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }


        }
    }
}
