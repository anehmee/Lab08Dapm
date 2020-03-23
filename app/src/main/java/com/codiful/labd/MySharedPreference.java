package com.codiful.labd;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreference {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        public MySharedPreference (Context context) {
            settings= context.getSharedPreferences("MyPref", context.MODE_PRIVATE);
             editor = settings.edit();
        }

        public void save(String text){
            editor.putString("text", text);
            editor.commit();
        }

        public String getValue(){
           return  settings.getString("text"," ");
        }

        public void clearSharedPreferences(){
            editor.clear();
            editor.commit();
        }
    }

