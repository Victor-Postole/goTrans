package com.android.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

public class Autentificare extends AppCompatActivity implements  View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autentificare);


        View buton_autentificare = findViewById(R.id.buton_autentificare);
        buton_autentificare.setOnClickListener(this);

        View buton_back = findViewById(R.id.back_arrow);
        buton_back.setOnClickListener(this);

        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
    }

    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.buton_autentificare:
                Intent autentificareIntent = new Intent(Autentificare.this, NotificationProfile.class);
                Autentificare.this.startActivity(autentificareIntent);
                break;
            case R.id.back_arrow:
                Intent backIntent = new Intent(Autentificare.this, Singup.class);
                Autentificare.this.startActivity(backIntent);
                break;
        }
    }
}
