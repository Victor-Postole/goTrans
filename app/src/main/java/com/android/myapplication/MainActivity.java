package com.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    String[]Car_brand= {"MAN 200", "MERCEDES E20","RENAULT A40","MAN 200", "MERCEDES E20","MAN 200", "MERCEDES E20","RENAULT A40","MAN 200", "MERCEDES E20"};
    String[]Car_number= {"B 27 RTJ", "IL 01 TMS", "CT 40 RMS","B 27 RTJ", "IL 01 TMS","B 27 RTJ", "IL 01 TMS", "CT 40 RMS","B 27 RTJ", "IL 01 TMS"};
    String[]Car_type = {"Frigorific, 15 tone","Cisterna 25 tone", "Container 50 tone","Frigorific, 15 tone","Cisterna 25 tone","Frigorific, 15 tone","Cisterna 25 tone", "Container 50 tone","Frigorific, 15 tone","Cisterna 25 tone"};
    String[]Car_drivers = {"Marian Trandafir", "Ionica Mihalache","Marcel Octavian","Mike Markula","Samsung Ionel","Xing", "Smantanel","Marica","Novac","MMAMA"};


    LinearLayout sterge, modifica;
    BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creeaza_transport);

//        ListView findListView = (ListView)findViewById(R.id.notificationListView);
//
//
//        CustomAdapter customAdapter = new CustomAdapter();
//        findListView.setAdapter(customAdapter);

//        ModificaSosferi modificaSosferi = new ModificaSosferi();
//        findListView.setAdapter(modificaSosferi);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        createBottomShitDialog();

    }

    @Override
    public  void onClick(View view) {
        switch (view.getId()){

        }
    }

    private void createBottomShitDialog(){
        if(bottomSheetDialog == null){
            View view = LayoutInflater.from(this).inflate(R.layout.fragment_modifica, null);

            bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setContentView(view);
        }
    }

    public void showFragmentModifica(View view){
        bottomSheetDialog.show();
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Car_brand.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.fragment_masini, null);

            TextView getCarBrand = convertView.findViewById(R.id.truckBrand);
            TextView getCarNumber = convertView.findViewById(R.id.carNumber);
            TextView getCarType = convertView.findViewById(R.id.carType);

            getCarBrand.setText(Car_brand[position]);
            getCarNumber.setText(Car_number[position]);
            getCarType.setText(Car_type[position]);

            return convertView;
        }
    }

    class ModificaSosferi extends BaseAdapter {
        @Override
        public int getCount() {
            return Car_drivers.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.fragment_soferi, null);

            TextView getDriversName = convertView.findViewById(R.id.driversName);
            TextView getDriversCarNumber = convertView.findViewById(R.id.driverNumber);


            getDriversName.setText(Car_drivers[position]);
            getDriversCarNumber.setText(Car_number[position]);

            return convertView;
        }
    }
}
