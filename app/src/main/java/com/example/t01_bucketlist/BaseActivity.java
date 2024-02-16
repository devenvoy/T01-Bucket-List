package com.example.t01_bucketlist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.widget.Toast;

import java.util.Objects;

public class BaseActivity extends AppCompatActivity {

    Dialog dialog;

    public void showProgress(){
        dialog = new Dialog(this);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(R.layout.progress_dialog);
        dialog.setCancelable(false);
        dialog.show();
    }

    public void hideProgress(){
        dialog.dismiss();
    }

    public void displayToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }
}