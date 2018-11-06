package com.keval.giver_seeker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText editTextMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        editTextMobile = findViewById(R.id.phoneNumber);

        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = Toast.makeText(getApplicationContext(),"hello world",Toast.LENGTH_SHORT);
                toast.show();

                String mobile = editTextMobile.getText().toString().trim();
                if(mobile.isEmpty() || mobile.length() < 10){
                    editTextMobile.setError("Enter a valid mobile");
                    editTextMobile.requestFocus();
                    return;
                }
                
                Intent intent = new Intent(LoginActivity.this, VerifyPhoneActivity.class);
                intent.putExtra("mobile", mobile);
                startActivity(intent);
            }
        });

        findViewById(R.id.registerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, RegisterUserActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    public void registerPage(View view)
    {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
//            ((TextView) findViewById(R.id.textSignInStatus)).setText(
//                    "User ID: " + user.getUid());
//            Toast.makeText(this, "User ID: " + user.getUid(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
            intent.putExtra("uid", user.getPhoneNumber());
            startActivity(intent);
        } else {
//            ((TextView) findViewById(R.id.textSignInStatus)).setText(
//                    "Error: sign in failed.");
            Toast.makeText(this, "Error: sign in failed.", Toast.LENGTH_SHORT).show();
        }
    }

}
