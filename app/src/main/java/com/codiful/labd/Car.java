package com.codiful.labd;

public class Car {
     String name;
     int imageResource ;

     public Car() {

     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public int getImageResource() {
          return imageResource;
     }

     public void setImageResource(int imageResource) {
          this.imageResource = imageResource;
     }

     public Car(String name, int imageResource) {
          this.name = name;
          this.imageResource = imageResource;
     }
}
