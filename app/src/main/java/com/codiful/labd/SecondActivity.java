package com.codiful.labd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView txt;
    private MySharedPreference sh;

    private  void initView(){
        txt =  (TextView) findViewById(R.id.txtview);
        sh =  new MySharedPreference(getApplicationContext());
    }

    private  void DisplayData()
    {
        if (sh.getValue().equals(" ")) // if no data found in sh get Intent
        {
            Intent i = getIntent();
            String empty_Value = i.getStringExtra("no_value");
            txt.setText(empty_Value);
        }
        else
        {
            txt.setText(sh.getValue());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();

        DisplayData();
    }
}
