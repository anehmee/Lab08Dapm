package com.codiful.labd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listOfCars;
    private static CarAdapter carAdapter;
    private EditText addNewCar;
    private Button addButton;
    private ArrayList<Car> c ;
    private void init(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addNewCar =  (EditText) findViewById(R.id.editText);
        addButton = (Button) findViewById(R.id.btn);

        listOfCars = (ListView) findViewById(R.id.lv_list_cars);
        carAdapter = new CarAdapter(MainActivity.this);
        carAdapter.addCar("Dacia",R.drawable.lab_car_icon);
        carAdapter.addCar("Dacia",R.drawable.lab_car_icon);

        carAdapter.addCar("Dacia",R.drawable.lab_car_icon);

        carAdapter.addCar("Dacia",R.drawable.lab_car_icon);
        carAdapter.notifyDataSetChanged();
        listOfCars.setAdapter(carAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carAdapter.addCar(addNewCar.getText().toString(),R.drawable.lab_car_icon);
            }
        });


    }


}
