package com.android.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InregistrareSecondStep extends AppCompatActivity implements  View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_second_step);

        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        View buton_finalizare = findViewById(R.id.buton_finalizare);
        buton_finalizare.setOnClickListener(this);

        View buton_back = findViewById(R.id.back_arrow);
        buton_back.setOnClickListener(this);
    }


    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.buton_finalizare:
                Intent intentInregistrareSecondStep = new Intent(InregistrareSecondStep.this, NotificationProfile.class);
                InregistrareSecondStep.this.startActivity(intentInregistrareSecondStep);
                break;
            case R.id.back_arrow:
                Intent backIntent = new Intent(InregistrareSecondStep.this, Inregistrare.class);
                InregistrareSecondStep.this.startActivity(backIntent);
                break;
        }
    }
}
