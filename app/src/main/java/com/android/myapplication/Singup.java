package com.android.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Singup extends AppCompatActivity implements View.OnClickListener {

    private Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);


        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


        View buton_autentificare = findViewById(R.id.buton_autentificare);
        buton_autentificare.setOnClickListener(this);
        View buton_inregistrare = findViewById(R.id.buton_inregistrare);
        buton_inregistrare.setOnClickListener(this);
    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.buton_autentificare:
                Intent intentAutentificare = new Intent(Singup.this, Autentificare.class);
                Singup.this.startActivity(intentAutentificare);
                break;
            case R.id.buton_inregistrare:
                Intent intentInregistrare = new Intent(Singup.this, Inregistrare.class);
                Singup.this.startActivity(intentInregistrare);
                break;
        }
    }

}
