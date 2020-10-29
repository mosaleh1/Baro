package com.runcode.baro.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.runcode.baro.R;

import static com.runcode.baro.data.network.NetworkUtilities.LoginUser;

public class LoginActivity extends AppCompatActivity {
    TextInputLayout emailTextInputLayout;
    TextInputLayout passwordTextInputLayout;
    Button registerBtn, loginBtn;
    String email, password;
    boolean isEndIconCheckedChecked = false;
    private static final String TAG = "LoginActivity";
    //firebase
    FirebaseAuth mAuth;
    FirebaseUser user;

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
            if (isDataFiled()) {
                if (passwordCorrectLength()) {
                    user = LoginUser(email, password, LoginActivity.this);
                    updateUI(user);
                } else {
                    passwordTextInputLayout.requestFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(passwordTextInputLayout.getEditText(), InputMethodManager.SHOW_IMPLICIT);
                    Toast.makeText(this, "the password should be 8 chars&numbers or more", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "please fill the missing data", Toast.LENGTH_SHORT).show();
                emailTextInputLayout.requestFocus();
            }

        });
        registerBtn.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

    }


    private boolean passwordCorrectLength() {
        return passwordTextInputLayout.getEditText().getText().length() >= 8;
    }

    private void getEmailAndPasswords() {
        email = emailTextInputLayout.getEditText().getText().toString();
        password = passwordTextInputLayout.getEditText().getText().toString();
        isDataFiled();
    }

    private boolean isDataFiled() {
        return !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password);
    }

    private void initViews() {
        emailTextInputLayout = findViewById(R.id.emailEdLogin);
        passwordTextInputLayout = findViewById(R.id.password_edLogin);
        registerBtn = findViewById(R.id.registerButton);
        loginBtn = findViewById(R.id.login_button);
        mAuth = FirebaseAuth.getInstance();
    }

    public void updateUI(FirebaseUser user) {
    }
}