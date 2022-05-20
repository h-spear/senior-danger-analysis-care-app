package com.example.sda_care.Service;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FirebaseStorageService {
    private static final String TAG = "FirebaseStorageService";

    private FirebaseStorage storage;
    private StorageReference storageRef;

    public FirebaseStorageService() {
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
    }

    public StorageReference getStorageRef() {
        return storageRef;
    }
}
