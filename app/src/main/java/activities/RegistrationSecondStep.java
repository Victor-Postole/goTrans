package activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.android.myapplication.R;

public class RegistrationSecondStep extends AppCompatActivity implements  View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_second_step);

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
                Intent intentInregistrareSecondStep = new Intent(RegistrationSecondStep.this, NotificationProfile.class);
                RegistrationSecondStep.this.startActivity(intentInregistrareSecondStep);
                break;
            case R.id.back_arrow:
                Intent backIntent = new Intent(RegistrationSecondStep.this, Registration.class);
                RegistrationSecondStep.this.startActivity(backIntent);
                break;
        }
    }
}
