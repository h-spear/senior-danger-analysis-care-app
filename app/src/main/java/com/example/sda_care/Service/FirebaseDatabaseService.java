package com.example.sda_care.Service;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseDatabaseService {
    private DatabaseReference databaseReference; //실시간 데이터베이스 처리
    public static final String UserAccount = "UserAccount";
    public static final String UserIdToken = "UserIdToken";
    public static final String SeniorListForCare = "SeniorListForCare";

    public FirebaseDatabaseService() {
        databaseReference = FirebaseDatabase.getInstance().getReference("capstone");
    }

    public DatabaseReference getReference() {
        return databaseReference;
    }
}
