package com.keval.giver_seeker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent intent = getIntent();
        String uid = intent.getStringExtra("uid");
        Toast.makeText(getApplicationContext(),"Hello "+uid,Toast.LENGTH_LONG).show();
    }
}