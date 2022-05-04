package com.example.sda_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.sda_care.Activity.DangerIdentificationActivity;
import com.example.sda_care.Activity.EditInformationActivity;
import com.example.sda_care.Activity.LoginActivity;
import com.example.sda_care.Activity.RegisterActivity;
import com.example.sda_care.Activity.SeniorCareListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(getApplicationContext(), EditInformationActivity.class);
        startActivity(intent);
    }
}