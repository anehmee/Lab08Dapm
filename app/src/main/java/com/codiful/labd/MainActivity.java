package com.codiful.labd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

private Button btnlogin;
private EditText username;
private EditText password;

    private void init(){
        btnlogin = (Button) findViewById(R.id.loginbtn);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById((R.id.password));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("student") && password.getText().toString().equals("student"))
                {
                    Intent i = new Intent(MainActivity.this,FindTheNumberActivity.class);
                    i.putExtra("username","student");
                    startActivity(i);
                }
            }
        });
    }


}
