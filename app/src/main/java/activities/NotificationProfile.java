package activities;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import com.android.myapplication.PagerAdapter;
import com.android.myapplication.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import fragments.Fragment_bottom_options;


public class NotificationProfile extends AppCompatActivity implements  View.OnClickListener{

    private AppBarConfiguration mAppBarConfiguration;

    public TextView masini,soferi;
    public ImageView avatar, adaugaOptiuni, notificationBell, driverChanges;
    public TextView documentNou, adaugaClient, adaugaSofer, adaugaMasina, uploadFactura, uploadContract;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;

    LinearLayout sterge, modifica;
    BottomSheetDialog bottomSheetDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications_profile);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);




        TabLayout tabLayout = findViewById(R.id.tab_expeditii);
        TabItem tabMasini = findViewById(R.id.tab_masini);
        TabItem tabSoferi = findViewById(R.id.tab_soferi);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewrPagerTabItems);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjEsImV4cCI6MTU4NjE3NTM0M30.8s3rMfrVMRymUo4ARjJPX9fEyC5YW-yu8ZjnWpfFDvw";
//        List<String> json_items = Arrays.asList("car_number","model","weight");
//        String json_url_cars = "https://cristi.gotrans.ro/cars/index?token=" + token;
//        String json_country = "cars";
//
//        HttpGetRequest cars_request = new HttpGetRequest(this, json_url_cars,json_country,json_items);
//        cars_request.execute();
//
        initImageView();
//        initTextView();
    }
//
//    public void runAfterRequestCompleted(List<String> json_objects){
//        Log.e("result2", json_objects.toString());
//    }



    private void initTextView() {

    }

    private void  initImageView(){
        this.adaugaOptiuni = findViewById(R.id.addNewOptions);
        this.adaugaOptiuni.setOnClickListener(this);

        this.notificationBell = findViewById(R.id.notificationBell);
        this.notificationBell.setOnClickListener(this);

        this.avatar = findViewById(R.id.profile_avatar);
        this.avatar.setOnClickListener(this);

        this.avatar = findViewById(R.id.profile_avatar);
        this.avatar.setOnClickListener(this);
    }


    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.notificationBell:
                Intent NotificationUser = new Intent(NotificationProfile.this, activities.NotificationUser.class);
                NotificationProfile.this.startActivity(NotificationUser);
                break;
            case R.id.addNewOptions:
                Fragment_bottom_options bottomSheetFragment = new Fragment_bottom_options();
                bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
                break;
        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.notificationProfileId);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }
}
