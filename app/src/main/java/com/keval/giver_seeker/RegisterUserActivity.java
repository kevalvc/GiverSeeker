package com.keval.giver_seeker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterUserActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private EditText orgName;
    private EditText orgRegno;
    private EditText userName;
    private EditText phNo;
    private ProgressBar progressBar;
    private String indOrOrg = "";
    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        orgName = (EditText)findViewById(R.id.orgName);
        orgRegno = (EditText)findViewById(R.id.orgRegNo);
        orgRegno.setEnabled(false);
        userName = (EditText)findViewById(R.id.userName);
        phNo = (EditText)findViewById(R.id.phNo);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        mAuth = FirebaseAuth.getInstance();


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.org:
                if (checked) {
                    indOrOrg = "organization";
                    orgRegno.setEnabled(true);
                    break;
                }
            case R.id.individual:
                if (checked){
                    indOrOrg = "individual";
                    orgRegno.setEnabled(false);
                    break;
                }
        }
    }

    public void registerUser(View view) {
        final String name = userName.getText().toString().trim();
        final String orgN = orgName.getText().toString().trim();
        String orgRegNumber = orgRegno.getText().toString().trim();
        final String phone = phNo.getText().toString().trim();

        if (name.isEmpty()) {
            userName.setError(getString(R.string.input_error_name));
            userName.requestFocus();
            return;
        }

        if (orgN.isEmpty()) {
            orgName.setError(getString(R.string.input_error_name));
            orgName.requestFocus();
            return;
        }

        if (orgRegno.isEnabled()==true&&orgRegNumber.isEmpty()) {
            orgRegno.setError(getString(R.string.input_error_email));
            orgRegno.requestFocus();
            return;
        }

        if (phone.isEmpty()) {
            phNo.setError(getString(R.string.input_error_phone));
            phNo.requestFocus();
            return;
        }

        if (phone.length() != 10) {
            phNo.setError(getString(R.string.input_error_phone_invalid));
            phNo.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        Intent intent = new Intent(RegisterUserActivity.this, VerifyPhoneActivity.class);
        intent.putExtra("mobile",phone );
        intent.putExtra("username",name );
        intent.putExtra("orgname",orgN );
        intent.putExtra("orgregno",orgRegNumber );
        intent.putExtra("indororg",indOrOrg );
        startActivity(intent);
    }
}