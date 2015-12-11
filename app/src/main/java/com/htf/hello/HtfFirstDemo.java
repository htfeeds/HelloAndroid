package com.htf.hello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HtfFirstDemo extends AppCompatActivity {
    private Button btnChange;
    private TextView txvHello;
    private TextView txvWelcome;

    private Button btnCheck;
    private EditText edtNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htf_first_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnChange = (Button) findViewById(R.id.btnChange);
        txvHello = (TextView) findViewById(R.id.txvHello);
        txvWelcome = (TextView) findViewById(R.id.txvWelcome);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = txvHello.getText().toString();
                txvHello.setText(txvWelcome.getText());
                txvWelcome.setText(temp);
            }
        });

        edtNumber = (EditText) findViewById(R.id.edtNumber);
        btnCheck = (Button) findViewById(R.id.btnCheck);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = edtNumber.getText().toString();
                try {
                    int n = Integer.parseInt(number);
                    Toast toast = Toast.makeText(getApplicationContext(), "It's a number", Toast.LENGTH_SHORT);
                    toast.show();
                } catch (NumberFormatException e) {
                    Toast toast = Toast.makeText(getApplicationContext(), "It's not a number", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        Button btnDialogActivity = (Button) findViewById(R.id.btnDialogActivity);
        btnDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HtfFirstDemo.this, DialogActivity.class);
                startActivity(intent);
            }
        });

        Button btnSubActivity = (Button) findViewById(R.id.btnSubActivity);
        btnSubActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HtfFirstDemo.this, SubActivity.class);
                startActivity(intent);
            }
        });

        Toast.makeText(getApplicationContext(), "onCreate() callback", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "The onStart() callback", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "The onResume() callback", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "The onPause() callback", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "The onStop() callback", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "The onDestroy() callback", Toast.LENGTH_SHORT).show();
    }
}
