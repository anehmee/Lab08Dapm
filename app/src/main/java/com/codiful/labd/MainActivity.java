package com.codiful.labd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button save;
    private Button activity;
    private EditText input;
    private MySharedPreference sh;

    private void initView() {
        save = (Button) findViewById(R.id.save);
        activity = (Button) findViewById(R.id.btn2);
        input = (EditText) findViewById(R.id.editText);

        sh = new MySharedPreference(getApplicationContext());
    }

    private void SaveData() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sh.save(input.getText().toString());
            }
        });
    }

    private void OpenActivity() {
        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("no_value","Oops ! no data saved , this message is from intent");
                startActivity(i);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        SaveData();
        OpenActivity();

    }


}
