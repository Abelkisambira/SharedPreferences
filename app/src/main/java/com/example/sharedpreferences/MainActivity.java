package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3;
    Button Save, View;
    SharedPreferences shared;
    public static final String OurPreferences="MyPrefs";
    public static final String Name = "nameKey";
    public static final String Phone="phoneKey";
    public static final String Email="emailkey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.name);
        ed2 =findViewById(R.id.phone);
        ed3 =findViewById(R.id.email);
        Save=findViewById(R.id.save);
        View=findViewById(R.id.view);

        //storing data into sharedpreferences

        shared=getSharedPreferences(OurPreferences,MODE_PRIVATE);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n,p,e;

                n= ed1.getText().toString();
                p= ed2.getText().toString();
                e= ed3.getText().toString();
                //creating an editor object to write to the file
                SharedPreferences.Editor editor =shared.edit();
                //stroing the key and it's value as the data fetched from edittext

                editor.putString(Name,n);
                editor.putString(Phone,p);
                editor.putString(Email,e);
                editor.commit();

                Toast.makeText(MainActivity.this, "Your data has been successfully saved", Toast.LENGTH_SHORT).show();


            }
        });

        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                calling a new intent
                Intent intent = new Intent(MainActivity.this,Shared2.class);
                startActivity(intent);
            }
        });
    }

}