package com.android.myapplication;

import org.json.*;
import java.util.*;


public class SmartJSONArray {

    private JSONArray jsonArray;

    public SmartJSONArray(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    public List<String> getFields(List<String> json_items) throws JSONException {
        List<String> result = new ArrayList<>();
        for(int i=0; i<jsonArray.length();i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            for (String json_item : json_items) {
                result.add(jsonObject1.get(json_item).toString());
            }
        }
        return result;

    }

    public <T> List<T> toList(JSONArray jsonArray) {
        ArrayList<T> result = new ArrayList<>();
        ///...
        return result;
    }
}
