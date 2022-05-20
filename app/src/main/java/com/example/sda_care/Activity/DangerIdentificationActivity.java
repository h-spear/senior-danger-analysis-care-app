package com.example.sda_care.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sda_care.Class.UserAccount;
import com.example.sda_care.R;
import com.example.sda_care.Service.FirebaseAuthService;
import com.example.sda_care.Service.FirebaseDatabaseService;
import com.example.sda_care.Service.FirebaseStorageService;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DangerIdentificationActivity extends AppCompatActivity {
    private FirebaseAuthService authService;

    private FirebaseStorageService storageService;
    private StorageReference storageRef;
    private StorageReference targetRef;

    private FirebaseDatabaseService dbService;
    private DatabaseReference databaseRef;

    private TextView textViewDangerMsg;
    private TextView textViewDangerSeniorName;
    private TextView textViewDangerSeniorPhone;
    private TextView textViewDangerSeniorAddress;
    private ImageView dangerImageView;

    private Button dangerSeniorCallButton;
    private Button dangerSeniorOkButton;

    private String seniorName;
    private String seniorPhone;
    private String seniorAddress;

    public static String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danger_identification);

        Log.e("image name: ", "" + imageName);

        authService = new FirebaseAuthService();

        storageService = new FirebaseStorageService();
        storageRef = storageService.getStorageRef();
        targetRef = storageRef.child(imageName);

        dbService = new FirebaseDatabaseService();
        databaseRef = dbService.getReference();

        dangerImageView = (ImageView) findViewById(R.id.dangerImageView);

        textViewDangerMsg = (TextView) findViewById(R.id.textViewDangerMsg);
        textViewDangerSeniorName = (TextView) findViewById(R.id.textViewDangerSeniorName);
        textViewDangerSeniorPhone = (TextView) findViewById(R.id.textViewDangerSeniorPhone);
        textViewDangerSeniorAddress = (TextView) findViewById(R.id.textViewDangerSeniorAddress);

        dangerSeniorCallButton = (Button) findViewById(R.id.dangerSeniorCallButton);
        dangerSeniorOkButton = (Button) findViewById(R.id.dangerSeniorOkButton);

        try {
            File localFile = File.createTempFile("img_", "jpg");
            targetRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                    dangerImageView.setImageBitmap(bitmap);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        databaseRef.child(FirebaseDatabaseService.SeniorListForCare).child(authService.getId()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Object obj = snapshot.getValue();
                if (obj == null) {
                    return;
                }
                String seniorIdToken = obj.toString().replace("{", "").replace("=1}", "");

                databaseRef.child(FirebaseDatabaseService.UserAccount).child(seniorIdToken).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        UserAccount userAccount = snapshot.getValue(UserAccount.class);
                        seniorName = userAccount.getName();
                        seniorPhone = userAccount.getPhone();
                        seniorAddress = userAccount.getAddress();
                        textViewDangerSeniorName.setText(seniorName);
                        textViewDangerSeniorPhone.setText(seniorPhone);
                        textViewDangerSeniorAddress.setText(seniorAddress);
                        textViewDangerMsg.setText("관리중인 시니어 " + seniorName + "님에 대한\n위험 상황이 인지되었습니다.");
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

        dangerSeniorCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tt = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + seniorPhone));
                startActivity(tt);
            }
        });

        dangerSeniorOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}