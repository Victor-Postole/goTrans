package com.android.myapplication;

import android.app.Activity;
import android.os.AsyncTask;

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

    public List<String> get_json_request(List<String> json_fields) {


        try{
            bufferdata = readInputStreamFromHTTPRequest( new URL(USG_URL));

            try {

                JSONArray jsonArray = stringToJsonArray(bufferdata, type_of_items);

                SmartJSONArray smartJSONArray = new SmartJSONArray(jsonArray);

                sorted_elements_from_json = smartJSONArray.getFields(json_fields);
                Data = concatenateList();

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

        return json_fields;
    }

    private String concatenateList() {
        String result ="";
        for (String element : sorted_elements_from_json) {
            result += element;
        }
        return result;
    }



    private JSONArray stringToJsonArray(String string, String jsonType) throws JSONException {
        JSONObject jsonObject = new JSONObject(string);
        return jsonObject.getJSONArray(jsonType);
    }

    private String readInputStreamFromHTTPRequest(URL url) throws IOException {
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
        return bufferdata;
    }

    public List<String> getSorted_elements_from_json() {
        return sorted_elements_from_json;
    }


}