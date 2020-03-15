package com.android.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ValleyJson extends AppCompatActivity {

    private TextView mtextViewResult;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("Message","Created activity");

        mtextViewResult = findViewById(R.id.text_view_result);
        mQueue = Volley.newRequestQueue(this);

        getJsonParse();

    }

    public void getJsonParse(){
        String url = "https://api.myjson.com/bins/kp9wz";

        Log.d("Message", "Before request");

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("employees");

                    for(int i = 0; i<jsonArray.length(); i++){
                        JSONObject employee = jsonArray.getJSONObject(i);

                        String firstName = employee.getString("firstname");
                        int age = employee.getInt("age");
                        String mail = employee.getString("mail");

                        Log.d("firstName", firstName);
                        Log.d("age", String.valueOf(age));
                        Log.d("mail", mail);

                    }
                }catch (JSONException e){
                    Log.d("Message", "On after request error");
                    e.fillInStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Message", "On request error");
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }
}
