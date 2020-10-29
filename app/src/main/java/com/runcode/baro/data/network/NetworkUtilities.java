package com.runcode.baro.data.network;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.runcode.baro.R;
import com.runcode.baro.ui.Activities.LoginActivity;
import com.runcode.baro.ui.Activities.MainActivity;
import com.runcode.baro.ui.Activities.RegisterActivity;

public class NetworkUtilities {
    private static final String TAG = "NetworkUtilities";
    private static FirebaseAuth mAuth;
    static FirebaseUser user;


    public static FirebaseUser LoginUser(String email, String password, Context context) {
        mAuth = FirebaseAuth.getInstance();
        // TODO: 10/16/2020 implement the login functionality
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_layout);
        AlertDialog dialog = builder.create();
        dialog.show();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        dialog.hide();
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success");
                        user = mAuth.getCurrentUser();
                        if (!(user != null && user.isEmailVerified())) {
                            AlertDialog.Builder dialog1 = new AlertDialog.Builder(context)
                                    .setCancelable(true)
                                    .setTitle("Verify your email")
                                    .setMessage("We sent you a verification Link to your email");
                            dialog1.setPositiveButton("Send it again", (d, v) -> {
                                user.sendEmailVerification();
                            });
                            dialog1.show();
                        } else {
                            context.startActivity(new Intent(context, MainActivity.class));
                            ((Activity) context).finish();
                        }
                    } else {
                        dialog.hide();
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        AlertDialog.Builder dialog1 = new AlertDialog.Builder(context)
                                .setCancelable(true)
                                .setTitle("Login Failed")
                                .setMessage("Error while logging you in.\nyou may need to register first\nor Check the internet Connection ");

                        dialog1.setPositiveButton("Register", (d, w) -> {
                            context.startActivity(new Intent(context, RegisterActivity.class));
                        });
                        dialog1.show();
                        Toast.makeText(context, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                        // ...
                    }

                    // ...
                });
        return user;
    }


    // Register
    public static FirebaseUser registerNewUser(String email, String password, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_layout);
        AlertDialog dialog = builder.create();
        dialog.show();
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        dialog.dismiss();
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success");
                        user = mAuth.getCurrentUser();
                        if (user != null) {
                            user.sendEmailVerification();
                        }
                        context.startActivity(new Intent(context, LoginActivity.class));
                    } else {
                        // If sign in fails, display a message to the user.
                        dialog.dismiss();
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(context, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                        user = null;
                    }

                });
        return user;
    }
}

