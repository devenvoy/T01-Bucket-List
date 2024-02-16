package com.example.t01_bucketlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class home_activity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        chipNavigationBar=findViewById(R.id.bottomnav);
        chipNavigationBar.setItemSelected(R.id.item1,true);
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                if (i == R.id.item1) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new home_frag()).commit();
                }
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new home_frag()).commit();


    }
}