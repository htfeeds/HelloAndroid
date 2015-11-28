package com.htf.hello;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.htf.utils.User;
import com.htf.utils.Utility;

import org.springframework.web.client.RestTemplate;

public class RegisterActivity extends AppCompatActivity {
    public static final String BASE_URL = "https://fmusic.herokuapp.com/rest/user/";

    private TextView txvError;
    private EditText edtName;
    private EditText edtEmail;
    private EditText edtUsername;
    private EditText edtPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txvError = (TextView) findViewById(R.id.txvError);
        edtName = (EditText) findViewById(R.id.edtName);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPwd = (EditText) findViewById(R.id.edtPassword);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public void navigateToUserList(View view) {
        Intent intent = new Intent(this, SecondLabActivity.class);
        // Clears History of Activity
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void navigateToLoginActivity(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        // Clears History of Activity
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void setDefaultValues() {
        edtName.setText("");
        edtEmail.setText("");
        edtUsername.setText("");
        edtPwd.setText("");
    }

    public void registerUser(View view) {
        //Get values
        String name = edtName.getText().toString();
        String username = edtUsername.getText().toString();
        String email = edtEmail.getText().toString();
        String password = edtPwd.getText().toString();

        if (Utility.isNotNull(name) && Utility.isNotNull(email) && Utility.isNotNull(username) && Utility.isNotNull(password)) {
            if (name.length() < 6) {
                Toast.makeText(getApplicationContext(), "Name must be at least 6 characters.", Toast.LENGTH_LONG).show();
            } else if (username.length() < 6) {
                Toast.makeText(getApplicationContext(), "Username must be at least 6 characters.", Toast.LENGTH_LONG).show();
            } else if (password.length() < 6) {
                Toast.makeText(getApplicationContext(), "Password must be at least 6 characters.", Toast.LENGTH_LONG).show();
            } else if (!Utility.validate(email)) {
                Toast.makeText(getApplicationContext(), "Please enter valid email", Toast.LENGTH_LONG).show();
            } else {
                User newUser = new User();
                newUser.setFullname(name);
                newUser.setUsername(username);
                newUser.setEmail(email);
                newUser.setPassword(password);

                new DoRegisterTask().execute(newUser);
            }
        }
        //When any of the Edit View control left blank
        else {
            Toast.makeText(getApplicationContext(), "Please fill the form, don't leave any field blank", Toast.LENGTH_LONG).show();
        }
    }

    private class DoRegisterTask extends AsyncTask<User, Void, User> {
        private ProgressDialog prgDialog;

        @Override
        protected void onPreExecute() {
            prgDialog = ProgressDialog.show(RegisterActivity.this, "Register", "Please wait....", true, false);
        }

        @Override
        protected void onPostExecute(User user) {
            if (user != null) {
                Toast.makeText(getApplicationContext(), "You are successfully registered!", Toast.LENGTH_LONG).show();
                setDefaultValues();
            } else {
                Toast.makeText(getApplicationContext(), "Error Occured!", Toast.LENGTH_LONG).show();
            }
            prgDialog.dismiss();
        }

        @Override
        protected User doInBackground(User... params) {
            String url = BASE_URL + "register";
            RestTemplate restTemplate = new RestTemplate();
            User created = restTemplate.postForObject(url, params[0], User.class);
            return created;
        }
    }
}