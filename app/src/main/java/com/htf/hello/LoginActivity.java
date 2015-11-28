package com.htf.hello;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.htf.utils.Credentials;
import com.htf.utils.Utility;

import org.springframework.web.client.RestTemplate;

public class LoginActivity extends AppCompatActivity {

    private TextView txvError;
    private EditText edtUsername;
    private EditText edtPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txvError = (TextView) findViewById(R.id.txvError);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPwd = (EditText) findViewById(R.id.edtPassword);
    }

    public void navigateToRegisterActivity(View view) {
        Intent loginIntent = new Intent(this, RegisterActivity.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(loginIntent);
    }

    public void navigatetoUserList() {
        SecondLabActivity.user = edtUsername.getText().toString();
        Intent intent = new Intent(this, SecondLabActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void loginUser(View view) {
        //Get values
        String username = edtUsername.getText().toString();
        String password = edtPwd.getText().toString();

        if (Utility.isNotNull(username) && Utility.isNotNull(password)) {
            if (username.length() < 6) {
                Toast.makeText(getApplicationContext(), "Username must be at least 6 characters.", Toast.LENGTH_LONG).show();
            } else if (password.length() < 6) {
                Toast.makeText(getApplicationContext(), "Password must be at least 6 characters.", Toast.LENGTH_LONG).show();
            } else {
                Credentials credentials = new Credentials(username, password);
                new DoLoginTask().execute(credentials);
            }
        }
        //When any of the Edit View control left blank
        else {
            Toast.makeText(getApplicationContext(), "Please fill the form, don't leave any field blank", Toast.LENGTH_LONG).show();
        }
    }

    private class DoLoginTask extends AsyncTask<Credentials, Void, Boolean> {
        private ProgressDialog prgDialog;

        @Override
        protected void onPreExecute() {
            prgDialog = ProgressDialog.show(LoginActivity.this, "Login", "Please wait....", true, false);
        }

        @Override
        protected Boolean doInBackground(Credentials... params) {
            String url = RegisterActivity.BASE_URL + "login";
            RestTemplate restTemplate = new RestTemplate();
            boolean b = restTemplate.postForObject(url, params[0], Boolean.class);

            return b;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if (aBoolean) {
                Toast.makeText(getApplicationContext(), "You are successfully logged in!", Toast.LENGTH_LONG).show();
                navigatetoUserList();
            } else {
                Toast.makeText(getApplicationContext(), "Username or Password is incorrect!", Toast.LENGTH_LONG).show();
            }
            prgDialog.dismiss();
        }
    }
}
