package com.andela.cakeoderingapp.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.andela.cakeoderingapp.R;
import com.andela.cakeoderingapp.utilities.Constants;
import com.andela.cakeoderingapp.utilities.Launcher;
import com.andela.cakeoderingapp.utilities.SoftKeyboard;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    private EditText fullNameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button signUpButton;
    private Button existingAccountButton;
    private LinearLayout signUpLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        initializeComponents();

    }

    private void initializeComponents() {

        fullNameEditText =  (EditText)findViewById(R.id.full_name_text);
        emailEditText = (EditText)findViewById(R.id.email_text);
        passwordEditText = (EditText)findViewById(R.id.password_text);
        signUpButton = (Button)findViewById(R.id.signup_button);
        existingAccountButton = (Button)findViewById(R.id.existing_account_button);
        signUpLinearLayout = (LinearLayout)findViewById(R.id.signup_container);
    }

//    public void signIn(View view) {
//
//        Launcher.launchActivity(this, SignInActivity.class);
//
//    }
    
    public void signUp(View view) {

        SoftKeyboard.hide(this);

        final String fullName = fullNameEditText.getText().toString().trim();
        final String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString();

        if (fullName.isEmpty()) {
            fullNameEditText.setError(getResources().getString(R.string.fullname_missing));

        } else if (email.isEmpty()) {
            emailEditText.setError(getResources().getString(R.string.email_missing));

        } else if (password.isEmpty()) {
            passwordEditText.setError(getResources().getString(R.string.password_missing));

        } else {

            signUpButton.setText(R.string.signing_up);
            signUp(fullName, email, password);

        }
    }

    private void signUp(String fullName,String email,String password) {

        Constants.firebaseRef.createUser(email, password, new Firebase.ValueResultHandler<Map<String, Object>>() {

            @Override
            public void onSuccess(Map<String, Object> result) {
                //System.out.println("Successfully created user account with uid: " + result.get("uid"));
                Snackbar.make(signUpLinearLayout, "User successfully created", Snackbar.LENGTH_LONG).show();
                Launcher.launchActivity(SignUpActivity.this, SignInActivity.class);
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                // there was an error
                signUpButton.setEnabled(true);
                signUpButton.setText("Sign Up");
                Snackbar.make(signUpLinearLayout, "Unable to create user", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    public void signIn(View view) {

        Launcher.launchActivity(this,SignInActivity.class);
    }

}
