package activities;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.android.myapplication.R;

public class Authentication extends AppCompatActivity implements  View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);


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
                Intent autentificareIntent = new Intent(Authentication.this, NotificationProfile.class);
                Authentication.this.startActivity(autentificareIntent);
                break;
            case R.id.back_arrow:
                Intent backIntent = new Intent(Authentication.this, Singup.class);
                Authentication.this.startActivity(backIntent);
                break;
        }
    }
}
