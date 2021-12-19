package com.example.fms.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fms.R;

public class Std_dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_dashboard);

        Intent intent = getIntent();
        String user = intent.getStringExtra("userid");
        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();

    }
}