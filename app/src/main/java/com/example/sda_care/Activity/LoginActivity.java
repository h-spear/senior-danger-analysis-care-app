package com.example.sda_care.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sda_care.R;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton;
    private Button registerButton;
    private EditText editTextLoginId;
    private EditText editTextLoginPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextLoginId = (EditText) findViewById(R.id.editTextLoginId);
        editTextLoginPwd = (EditText) findViewById(R.id.editTextLoginPwd);
        loginButton = (Button) findViewById(R.id.loginButton);
        registerButton = (Button) findViewById(R.id.registerButton);

        loginButton.setOnClickListener(view -> onClickLoginButton());
        registerButton.setOnClickListener(view -> onClickRegisterButton());
    }

    private void onClickLoginButton() {
        // 로그인 버튼 클릭했을 때 이벤트 처리...
    }

    private void onClickRegisterButton() {
        // 회원가입 버튼 클릭했을 때 이벤트 처리...
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}