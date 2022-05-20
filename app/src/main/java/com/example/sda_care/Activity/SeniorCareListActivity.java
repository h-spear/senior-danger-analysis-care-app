package com.example.sda_care.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sda_care.Class.UserAccount;
import com.example.sda_care.R;
import com.example.sda_care.Service.FirebaseAuthService;
import com.example.sda_care.Service.FirebaseDatabaseService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class SeniorCareListActivity extends AppCompatActivity {
    private FirebaseAuthService authService;
    private FirebaseDatabaseService dbService;
    private DatabaseReference databaseRef;

    private Button logoutButton;
    private Button seniorCallButton;

    private TextView textViewSeniorName;
    private TextView textViewSeniorPhone;
    private TextView textViewSeniorAddress;

    private String seniorName;
    private String seniorPhone;
    private String seniorAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_care_list);

        authService = new FirebaseAuthService();
        dbService = new FirebaseDatabaseService();
        databaseRef = dbService.getReference();

        textViewSeniorName = (TextView) findViewById(R.id.textViewSeniorName);
        textViewSeniorPhone = (TextView) findViewById(R.id.textViewSeniorPhone);
        textViewSeniorAddress = (TextView) findViewById(R.id.textViewSeniorAddress);

        logoutButton = (Button) findViewById(R.id.logoutButton);
        seniorCallButton = (Button) findViewById(R.id.seniorCallButton);

        databaseRef.child(FirebaseDatabaseService.SeniorListForCare).child(authService.getId()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Object obj = snapshot.getValue();
                if (obj == null) {
                    return;
                }
                String seniorIdToken = obj.toString().replace("{", "").replace("=1}", "");
                //Log.e(TAG, " " + obj + " " + authService.getId());

                databaseRef.child(FirebaseDatabaseService.UserAccount).child(seniorIdToken).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        UserAccount userAccount = snapshot.getValue(UserAccount.class);
                        seniorName = userAccount.getName();
                        seniorPhone = userAccount.getPhone();
                        seniorAddress = userAccount.getAddress();
                        textViewSeniorName.setText(seniorName);
                        textViewSeniorPhone.setText(seniorPhone);
                        textViewSeniorAddress.setText(seniorAddress);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        seniorCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tt = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + seniorPhone));
                startActivity(tt);
            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(SeniorCareListActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}