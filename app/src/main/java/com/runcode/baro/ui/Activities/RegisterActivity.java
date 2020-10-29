package com.runcode.baro.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.runcode.baro.R;
import com.runcode.baro.data.network.NetworkUtilities;
import com.runcode.baro.databinding.ActivityRegisterBinding;
import com.runcode.baro.pojo.User;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.URIResolver;

public class RegisterActivity extends AppCompatActivity implements FirebaseAuth.AuthStateListener {

    private String email, password;
    private ActivityRegisterBinding mBinding;
    private boolean isValidEmail, isValidPassword;
    FirebaseUser currentUser;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        clickListeners();
        mAuth = FirebaseAuth.getInstance();
        mAuth.addAuthStateListener(this);
    }

    private void clickListeners() {
        mBinding.registerFab.setOnClickListener(v -> {
            email = checkAndGetEmail();
            password = checkAndGetPassword();
            if (isValidEmail && isValidPassword) {
                NetworkUtilities.registerNewUser(email, password, this);
                currentUser = FirebaseAuth.getInstance().getCurrentUser();
                FirebaseAuth.getInstance().addAuthStateListener(firebaseAuth -> {
                    if (firebaseAuth.getCurrentUser() != null) {
                        AlertDialog.Builder dialog = new AlertDialog.Builder(this)
                                .setCancelable(true)
                                .setTitle("Data sent Successfully")
                                .setMessage("please check you email to verify your account");
                        dialog.show();
                    }
                });

            } else {
                Toast.makeText(this, "please fill the missing Data\nor type it correctly", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void uploadUserData(FirebaseUser currentUser) {
        User user = new User();
        List<String> list = new ArrayList<>();
        user.setEnrolledCourses(list);
        user.setuId(currentUser.getUid());
        user.setUserName(mBinding.userFullName.getEditText().getText().toString());
        user.setUserEmail(mBinding.emailEdRegister.getEditText().getText().toString());
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        db.getReference().child(getString(R.string.users_table))
                .child(currentUser.getUid())
                .setValue(user).addOnCompleteListener(this, task -> {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(this, "registered Successfully", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(this, "error while register please try again", Toast.LENGTH_SHORT).show();
                    }
        });
        mAuth.signOut();
    }

    private String checkAndGetPassword() {
        String password = mBinding.passwordRegister.getEditText().getText().toString();
        if (password.trim().length() >= 8) {
            isValidPassword = true;
            return password;
        }
        return "";
    }

    private String checkAndGetEmail() {
        String email = mBinding.emailEdRegister.getEditText().getText().toString();
        if (email.contains("@") && email.contains(".")) {
            isValidEmail = true;
            return email;
        }
        return "";
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        if (firebaseAuth.getCurrentUser() != null) {
            uploadUserData(firebaseAuth.getCurrentUser());
        }
    }
}