package com.codiful.labd;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class FindTheNumberActivity extends AppCompatActivity {


    private Button guess;
    private EditText input;
    private TextView guessText;
    Random randGen = new Random();
    int ranNum;
    int Low = 0;
    int High = 20;
    int count = 0;
    int N;
    private void Random(){
        randGen = new Random();
        N = randGen.nextInt(High-Low) + Low;
    }
    private void init(){
        guess = (Button) findViewById(R.id.guess);
        input = (EditText) findViewById(R.id.input);
        guessText = (TextView) findViewById((R.id.guessText));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_the_number);
        init();
        Random();
        guessText.setText("Number between " + " " + String.valueOf(Low)  + " " + "and"+   " " + String.valueOf(High)  );
        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                int number = Integer.valueOf(input.getText().toString());
                Log.i("correctNumber",String.valueOf(N));
                if(number == N){
                    guessText.setText(String.valueOf(N) + " Good Guess!");
                }else if(number > N){
                    guessText.setText(number+ " is too HIGH!");
                }else if(number < N){
                    guessText.setText(number + " is too LOW!");
                }
                if (count == 3)
                {
                    Toast.makeText(FindTheNumberActivity.this,"GAME OVER !" ,  Toast.LENGTH_SHORT).show();
                }
                guess.setBackgroundColor(Color.BLUE);
            }
        });
    }
}
