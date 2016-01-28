package com.andela.cakeoderingapp.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.andela.cakeoderingapp.R;
import com.andela.cakeoderingapp.dal.CakeDatacollection;
import com.andela.cakeoderingapp.dal.DataCallback;
import com.andela.cakeoderingapp.models.Cake;
import com.andela.cakeoderingapp.models.Category;
import com.andela.cakeoderingapp.utilities.Constants;
import com.andela.cakeoderingapp.utilities.ImageConverter;
import com.andela.cakeoderingapp.utilities.ImageProcessCallback;
import com.andela.cakeoderingapp.utilities.Launcher;
import com.andela.cakeoderingapp.utilities.SoftKeyboard;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = "IMAGE ENCODING";
    private EditText fullNameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button signUpButton;
    private Button existingAccountButton;
    private LinearLayout signUpLinearLayout;
    private ImageView imageView;

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
        imageView = (ImageView) findViewById(R.id.imageView2);
    }

//    public void signIn(View view) {
//
//        Launcher.launchActivity(this, SignInActivity.class);
//
//    }
    
    public void signUp(View view) {

        CakeDatacollection collection = new CakeDatacollection("cake", Cake.class);
        collection.getAll(new DataCallback<List>() {
            @Override
            public void onSuccess(List value) {
                Cake cake = (Cake) value.get(0);
                Picasso.with(getApplicationContext())
                        .load(cake.getSnapshot())
                        .centerCrop()
                        .into(imageView);
                //ImageConverter converter = new ImageConverter("");

//                converter.decode(cake.getSnapshot(), new ImageProcessCallback() {
//                    @Override
//                    public void onSuccess(String url) {
//                        Log.d(TAG, "Success");
//                    }
//
//                    @Override
//                    public void onError(String error) {
//                        Log.d(TAG, error);
//                    }
//
//                    @Override
//                    public void onSuccess(Bitmap bitmap) {
//                        Picasso.with(getApplicationContext())
//                                .load(ca)
//                    }
//                });
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, error);

            }
        });

//        Category category = new Category("003", "Weddings");
//
//        final Cake cake = new Cake("cake002", "ChocolateIce");
//        cake.setCategory(category);
//        final CakeDatacollection collection = new CakeDatacollection("cake", Cake.class);
//        ImageConverter converter = new ImageConverter("/mnt/sdcard/Cakes/GrapesDrape2.JPG");
//        converter.encode(new ImageProcessCallback() {
//            @Override
//            public void onSuccess(String url) {
//                cake.setSnapshot(url);
//                collection.save(cake, new DataCallback() {
//                    @Override
//                    public void onSuccess(String value) {
//                        Log.d(TAG, value);
//                    }
//
//                    @Override
//                    public void onError(String error) {
//
//                    }
//                });
//            }
//
//            @Override
//            public void onError(String error) {
//
//            }
//
//            @Override
//            public void onSuccess(Bitmap bitmap) {
//
//            }
        //});
//        SoftKeyboard.hide(this);
//
//        final String fullName = fullNameEditText.getText().toString().trim();
//        final String email = emailEditText.getText().toString().trim();
//        String password = passwordEditText.getText().toString();
//
//        if (fullName.isEmpty()) {
//            fullNameEditText.setError(getResources().getString(R.string.fullname_missing));
//
//        } else if (email.isEmpty()) {
//            emailEditText.setError(getResources().getString(R.string.email_missing));
//
//        } else if (password.isEmpty()) {
//            passwordEditText.setError(getResources().getString(R.string.password_missing));
//
//        } else {
//
//            signUpButton.setText(R.string.signing_up);
//            signUp(fullName, email, password);
//
//        }
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
