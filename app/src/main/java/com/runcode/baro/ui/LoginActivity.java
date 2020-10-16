package com.runcode.baro.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.runcode.baro.R;

public class LoginActivity extends AppCompatActivity {
    TextInputLayout emailTextInputLayout;
    TextInputLayout passwordTextInputLayout ;
    Button registerBtn,loginBtn ;
    String email, password ;
    private static final String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        clickListeners();
    }

    private void clickListeners() {
        loginBtn.setOnClickListener(v ->
        {
            getEmailAndPasswords();
            LoginUser(email,password);
        });
    }

    private void LoginUser(String email, String password) {
        // TODO: 10/16/2020 implement the login functionality

    }

    private void getEmailAndPasswords() {
        email = emailTextInputLayout.getEditText().getText().toString();
        password = passwordTextInputLayout.getEditText().getText().toString();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "please fill the missing data", Toast.LENGTH_SHORT).show();
        }
    }

    private void initViews() {
        emailTextInputLayout = findViewById(R.id.emailEdLogin);
        passwordTextInputLayout = findViewById(R.id.password_edLogin);
        registerBtn = findViewById(R.id.registerButton);
        loginBtn = findViewById(R.id.login_button);
    }
}