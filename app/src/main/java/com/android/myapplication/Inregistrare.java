package com.android.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inregistrare extends AppCompatActivity implements  View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


        View buton_continua = findViewById(R.id.buton_continua);
        buton_continua.setOnClickListener(this);

        View buton_back = findViewById(R.id.back_arrow);
        buton_back.setOnClickListener(this);


        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjEsImV4cCI6MTU4NjE3NTM0M30.8s3rMfrVMRymUo4ARjJPX9fEyC5YW-yu8ZjnWpfFDvw";
        List<String> json_items = Arrays.asList("name");

        String json_url_city = "https://cristi.gotrans.ro/cities/index?token=" + token;
        String json_city = "cities";

        HttpGetRequest first_city_request = new HttpGetRequest(json_url_city,json_city,json_items);
        first_city_request.execute();


        ArrayAdapter<String> adapter_city = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, first_city_request.getSorted_elements_from_json());
        adapter_city.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems_city = (Spinner) findViewById(R.id.register_city);
        sItems_city.setAdapter(adapter_city);


        String json_url_country = "https://cristi.gotrans.ro/countries/index?token=" + token;
        String json_country = "countries";
        HttpGetRequest second_request = new HttpGetRequest(json_url_country,json_country,json_items);
        second_request.execute();

        ArrayAdapter<String> adapter_country = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, second_request.getSorted_elements_from_json());
        adapter_country.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems_country = (Spinner) findViewById(R.id.register_country);
        sItems_country.setAdapter(adapter_country);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.buton_continua:
                Intent intentInregistrareSecondStep = new Intent(Inregistrare.this, InregistrareSecondStep.class);
                Inregistrare.this.startActivity(intentInregistrareSecondStep);
                break;
            case R.id.back_arrow:
                Intent backIntent = new Intent(Inregistrare.this, Singup.class);
                Inregistrare.this.startActivity(backIntent);
                break;
        }
    }
}
