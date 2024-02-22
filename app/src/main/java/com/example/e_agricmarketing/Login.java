package com.example.e_agricmarketing;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private EditText username, telephone, password, name;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        telephone = (EditText) findViewById(R.id.telephonenum);
        password = (EditText) findViewById(R.id.password1);
        name = (EditText) findViewById(R.id.uname);
        new ProgressDialog(this);

        Button makeAccount = (Button) findViewById(R.id.createAdd);
        user = new User(this, null,1);
        makeAccount.setOnClickListener(v -> createAccount());
    }
    public void createAccount(){
        String name1 = name.getText().toString();
        String phone = telephone.getText().toString();
        String password1 = password.getText().toString();
        String username1 = username.getText().toString();
        String MobilePattern = "[0-9]{10}";


        if(TextUtils.isEmpty(name1) || (name1.toCharArray().length<5) || !isNameValid(name1)) {
            Toast.makeText(this, "Please enter a valid name with minimum 5 letters", Toast.LENGTH_SHORT).show();
        }
        else if(!telephone.getText().toString().matches(MobilePattern)){
            Toast.makeText(this, "Please a valid phone number", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password1) || (password1.toCharArray().length<5)){
            Toast.makeText(this, "Please enter a valid password of minimum 5 characters", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(username1) || (username1.toCharArray().length<5) ){
            Toast.makeText(this, "Please enter a valid username of minimum 5 characters", Toast.LENGTH_SHORT).show();
        }
        else{

            try{
                user.setPassword(password1);
                user.setTelephoneNumber(phone);
                user.setUsername(username1);
                user.setName(name1);
                user.createAccount();
                Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }


        }
    }

    private boolean isNameValid(String name) {
        boolean valid = true;
        String regex = "[a-zA-Z ]+";

        if (!name.matches(regex)) {
            valid = false;
        }
        return valid;
    }

}
