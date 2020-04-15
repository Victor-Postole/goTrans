package com.android.myapplication;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpGetRequest extends AsyncTask<Void, Void, Void> {

    public HttpGetRequest(String USG_URL, String type_of_items, List<String> json_items) {
        this.USG_URL = USG_URL;
        this.type_of_items = type_of_items;
        this.json_items = json_items;
    }

    public HttpGetRequest(Activity caller, String USG_URL, String type_of_items, List<String> json_items) {
        this.USG_URL = USG_URL;
        this.type_of_items = type_of_items;
        this.json_items = json_items;
        this.caller = caller;
    }

    private  final String USG_URL;
    private String bufferdata = "", finalData = "", Data = "", type_of_items  = "";
    private List<String> json_items =  new ArrayList<String>();
    private List<String> sorted_elements_from_json =  new ArrayList<String>();
    private Activity caller;

   @Override
    protected Void doInBackground(Void... voids){
       get_json_request(json_items);

       return null;
   }

    @Override
    protected void onPostExecute(Void aVoid) {

        super.onPostExecute(aVoid);
        //Log.e("result1", sorted_elements_from_json.toString());
        //caller.runAfterRequestCompleted(sorted_elements_from_json);
    }

    public List<String> get_json_request(List<String> json_items) {

        URL url;

        try{
            url = new URL(USG_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line="";

            while (line != null){
                line = bufferedReader.readLine();
                bufferdata = bufferdata + line;
            }

            try {

                JSONObject jsonObject = new JSONObject(bufferdata);
                JSONArray jsonArray = jsonObject.getJSONArray(type_of_items);

                for(int i=0; i<jsonArray.length();i++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

//                   JSONObject proprieties =  jsonObject1.getJSONObject("cities");
//
                    for (String json_item : json_items) {
                        finalData =  jsonObject1.get(json_item).toString();
                        sorted_elements_from_json.add(finalData);
                    }
                    Data = Data + finalData;
                }
//                for (String json_item : sorted_elements_from_json) {
//                    Log.e("eeeee",json_item.toString());
//                }
            }catch (JSONException e){
                e.printStackTrace();
            }

        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return json_items;
    }

    public List<String> getSorted_elements_from_json() {
        return sorted_elements_from_json;
    }


}