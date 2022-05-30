package com.example.sda_care.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sda_care.Class.PreferenceManager;
import com.example.sda_care.Class.UserAccount;
import com.example.sda_care.R;
import com.example.sda_care.Service.FirebaseAuthService;
import com.example.sda_care.Service.FirebaseDatabaseService;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class SplashActivity extends AppCompatActivity {
    private Context context;
    private FirebaseAuthService authService;
    private FirebaseDatabaseService dbService;
    private DatabaseReference databaseRef;

    private String message = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView splashImageView = (ImageView) findViewById(R.id.splashImageView);
        splashImageView.setImageResource(R.drawable.logo);

        context = this;
        authService = new FirebaseAuthService();
        dbService = new FirebaseDatabaseService();
        databaseRef = dbService.getReference();

        message = getIntent().getStringExtra("message");
        DangerIdentificationActivity.imageName = message;

        if (!authService.isLogin()) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 2000);
        } else {
            databaseRef.child(FirebaseDatabaseService.UserAccount).child(authService.getUid()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    UserAccount userAccount = snapshot.getValue(UserAccount.class);
                    PreferenceManager.setString(context, PreferenceManager.NAME, userAccount.getName());
                    PreferenceManager.setString(context, PreferenceManager.ID_TOKEN, userAccount.getIdToken());
                    PreferenceManager.setString(context, PreferenceManager.PHONE, userAccount.getPhone());;
                    PreferenceManager.setString(context, PreferenceManager.ADDRESS, userAccount.getPhone());

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            moveNextActivity();
                        }
                    }, 2000);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }

    private void moveNextActivity() {
        if (message == null || message.length() <= 2) {
            Intent intent;
            intent = new Intent(SplashActivity.this, SeniorCareListActivity.class);
            startActivity(intent);
        } else {
            Intent intent;
            intent = new Intent(SplashActivity.this, DangerIdentificationActivity.class);
            startActivity(intent);
        }
        finish();
    }
}