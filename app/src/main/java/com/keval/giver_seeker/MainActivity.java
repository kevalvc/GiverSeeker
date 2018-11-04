package com.keval.giver_seeker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
//            ((TextView) findViewById(R.id.textSignInStatus)).setText(
//                    "User ID: " + user.getUid());
            Toast.makeText(this, "User ID: " + user.getUid(), Toast.LENGTH_SHORT).show();
        } else {
//            ((TextView) findViewById(R.id.textSignInStatus)).setText(
//                    "Error: sign in failed.");
            Toast.makeText(this, "Error: sign in failed.", Toast.LENGTH_SHORT).show();
        }
    }

}
