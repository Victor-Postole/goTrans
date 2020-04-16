package com.android.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdaugaMasina extends AppCompatActivity implements  View.OnClickListener{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_masina);

        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
    }

    @Override
    public void onClick(View v) {

    }
}
