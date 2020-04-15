package com.android.myapplication;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;


public class NotificationProfile extends AppCompatActivity implements  View.OnClickListener{

    private AppBarConfiguration mAppBarConfiguration;

    public TextView masini,soferi;
    public ImageView avatar, adaugaOptiuni, notificationBell;
    public TextView documentNou, adaugaClient, adaugaSofer, adaugaMasina, uploadFactura, uploadContract;

    LinearLayout sterge, modifica;
    BottomSheetDialog bottomSheetDialog;

    DrawerLayout drawer;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications_profile);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.avatar);




//
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjEsImV4cCI6MTU4NjE3NTM0M30.8s3rMfrVMRymUo4ARjJPX9fEyC5YW-yu8ZjnWpfFDvw";
//        List<String> json_items = Arrays.asList("car_number","model","weight");
//        String json_url_cars = "https://cristi.gotrans.ro/cars/index?token=" + token;
//        String json_country = "cars";
//
//        HttpGetRequest cars_request = new HttpGetRequest(this, json_url_cars,json_country,json_items);
//        cars_request.execute();
//
//        try
//        {
//            this.getSupportActionBar().hide();
//        }
//        catch (NullPointerException e){}


        initImageView();
        initTextView();
    }

//
//    public void runAfterRequestCompleted(List<String> json_objects){
//        Log.e("result2", json_objects.toString());
//    }



    private void initTextView() {

    }

    private void  initImageView(){
        this.adaugaOptiuni = (ImageView) findViewById(R.id.addNewOptions);
        this.adaugaOptiuni.setOnClickListener(this);

        this.notificationBell = (ImageView) findViewById(R.id.notificationBell);
        this.notificationBell.setOnClickListener(this);

        this.avatar = (ImageView) findViewById(R.id.profile_avatar);
        this.avatar.setOnClickListener(this);
    }


    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.notificationBell:
                Intent NotificationUser = new Intent(NotificationProfile.this, NotificationUser.class);
                NotificationProfile.this.startActivity(NotificationUser);
                break;
            case R.id.addNewOptions:
                Fragment_optiuni bottomSheetFragment = new Fragment_optiuni();
                bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
                break;

            case R.id.profile_avatar:


                break;

        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.notificationProfileId);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
