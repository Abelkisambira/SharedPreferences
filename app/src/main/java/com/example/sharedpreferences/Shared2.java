package com.example.sharedpreferences;

import static com.example.sharedpreferences.MainActivity.Email;
import static com.example.sharedpreferences.MainActivity.Name;
import static com.example.sharedpreferences.MainActivity.OurPreferences;
import static com.example.sharedpreferences.MainActivity.Phone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Shared2 extends AppCompatActivity {
    TextView name,phone,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared2);
        name = findViewById(R.id.rname);
        phone=findViewById(R.id.rphone);
        email=findViewById(R.id.remail);

        SharedPreferences shared = getApplicationContext().getSharedPreferences(OurPreferences,MODE_PRIVATE);

        String n,p,e;
//        Name,Phone and Email keys imported from MainActivity
        n=shared.getString(Name, " ");
        p=shared.getString(Phone,"");
        e=shared.getString(Email,"");

        name.setText(n);
        phone.setText(p);
        email.setText(e);

    }
}