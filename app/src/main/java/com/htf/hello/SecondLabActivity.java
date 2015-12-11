package com.htf.hello;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.htf.adapters.UserAdapter;
import com.htf.utils.PrefUtils;
import com.htf.utils.User;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class SecondLabActivity extends AppCompatActivity {
    private TextView txvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_lab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String loggedInUserName = PrefUtils.getFromPrefs(SecondLabActivity.this, PrefUtils.PREFS_LOGIN_USERNAME_KEY, "");
        if (loggedInUserName.equals("")) {
            loggedInUserName = "Guest";
        }

        txvUser = (TextView) findViewById(R.id.txvUser);
        txvUser.setText("Hi, " + loggedInUserName);

        new GetUserList().execute();
    }

    public void goRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void goLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private class GetUserList extends AsyncTask<Void, Void, List<User>> {
        private ProgressDialog prgDialog;

        @Override
        protected List<User> doInBackground(Void... params) {
            String url = RegisterActivity.BASE_URL + "list";
            RestTemplate restTemplate = new RestTemplate();
            User[] users = restTemplate.getForObject(url, User[].class);

            return Arrays.asList(users);
        }

        @Override
        protected void onPreExecute() {
            prgDialog = ProgressDialog.show(SecondLabActivity.this, "Getting UserList", "Please wait....", true, false);
        }

        @Override
        protected void onPostExecute(List<User> users) {
            UserAdapter adapter = new UserAdapter(SecondLabActivity.this, R.id.txvUsername, users);
            ListView lsv = (ListView) findViewById(R.id.lsvUsers);
            lsv.setAdapter(adapter);
            prgDialog.dismiss();
        }
    }
}
