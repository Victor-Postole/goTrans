package com.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity{

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String json_url = "https://cristi.gotrans.ro/cities/index?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjEsImV4cCI6MTU4NjE3NTM0M30.8s3rMfrVMRymUo4ARjJPX9fEyC5YW-yu8ZjnWpfFDvw";
//        String json_city = "cities";
//        List<String> json_items = Arrays.asList("name", "car_number");
//
//        HttpGetRequest first_city_request = new HttpGetRequest(json_url,json_city,json_items);
//        first_city_request.execute();

        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                Intent myIntent = new Intent(MainActivity.this, Singup.class);
                MainActivity.this.startActivity(myIntent);
                finish();
            }
        }, 1000);
    }

}
