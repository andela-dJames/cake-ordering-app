package com.andela.cakeoderingapp.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.andela.cakeoderingapp.R;
import com.andela.cakeoderingapp.models.User;
import com.andela.cakeoderingapp.utilities.Constants;
import com.andela.cakeoderingapp.utilities.Launcher;
import com.andela.cakeoderingapp.utilities.SharedPreferenceManager;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class SignInActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button signInButton;
    private LinearLayout signInLayout;
    private SharedPreferenceManager sharedPreferenceManager;
    private String email;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        user = new User();

        emailEditText = (EditText)findViewById(R.id.email_text);
        passwordEditText = (EditText)findViewById(R.id.password_text);
        signInButton = (Button)findViewById(R.id.signin_button);
        signInLayout = (LinearLayout)findViewById(R.id.signin_layout);

        email = "";

        sharedPreferenceManager = new SharedPreferenceManager(this);
    }


    public void signIn(View view) {

        email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        signIn(email,password);
    }

    private void signIn(final String email, String password) {

        Constants.firebaseRef.authWithPassword(email, password, new Firebase.AuthResultHandler() {

            @Override
            public void onAuthenticated(AuthData authData) {

                user.setId(authData.getUid());
                sharedPreferenceManager.saveCurrentUser(email);
                Launcher.launchActivity(SignInActivity.this,MainActivity.class);
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {

                Snackbar.make(signInLayout,"Sign in unsuccessful",Snackbar.LENGTH_LONG).show();
            }
        });
    }

}
