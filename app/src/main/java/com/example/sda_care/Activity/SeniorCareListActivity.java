package com.example.sda_care.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sda_care.R;
import com.google.firebase.auth.FirebaseAuth;

public class SeniorCareListActivity extends AppCompatActivity {
    private Button logoutButton;
    private Button seniorCallButton;
    private Button editInfoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_care_list);

        logoutButton = (Button) findViewById(R.id.logoutButton);
        seniorCallButton = (Button) findViewById(R.id.seniorCallButton);
        editInfoButton = (Button) findViewById(R.id.editInfoButton);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(SeniorCareListActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        editInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeniorCareListActivity.this, EditInformationActivity.class);
                startActivity(intent);
            }
        });

        seniorCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tt = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01089258114"));
                startActivity(tt);
            }
        });
    }
}