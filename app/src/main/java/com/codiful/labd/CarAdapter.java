package com.codiful.labd;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class CarAdapter extends BaseAdapter{
     Activity context;
     ArrayList<Car> cars ;


    public CarAdapter (Activity context) {
        this.context = context;
        cars = new ArrayList<>();

    }

    public void addCar(String nameCar, int resource){
        Car car = new Car();
        car.name = nameCar;
       car.imageResource = resource;
       cars.clear();
        cars.add(car);
        this.notifyDataSetChanged();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View element;

        LayoutInflater layoutInflater = context.getLayoutInflater();
        element = layoutInflater.inflate(R.layout.list_item, null);
        TagCar car = new TagCar();
        car.nametxt = element.findViewById(R.id.iv_text_element);
        car.img = element.findViewById(R.id.iv_image_element);
        element.setTag(car);

        TagCar tag = (TagCar) element.getTag();
        tag.nametxt.setText(cars.get(i).name);
        tag.img.setImageResource(cars.get(i).imageResource);
        return element;
    }


    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
