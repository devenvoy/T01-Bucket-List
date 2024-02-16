package com.example.t01_bucketlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class home_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new home_frag()).commit();
    }
}