package activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.myapplication.R;

import fragments.Fragment_bottom_options;


public class NotificationUser extends AppCompatActivity implements  View.OnClickListener{

    public ImageView avatar, adaugaOptiuni, notificationBell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications_user);




    }


    private void  initImageView(){
        this.adaugaOptiuni = (ImageView) findViewById(R.id.addNewOptions);
        this.adaugaOptiuni.setOnClickListener(this);

        this.notificationBell = (ImageView) findViewById(R.id.notificationBell);
        this.notificationBell.setOnClickListener(this);
    }


    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.notificationBell:
                Intent NotificationUser = new Intent(NotificationUser.this, NotificationUser.class);
                NotificationUser.this.startActivity(NotificationUser);
                break;
            case R.id.addNewOptions:
                Fragment_bottom_options bottomSheetFragment = new Fragment_bottom_options();
                bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
                break;
        }
    }
}