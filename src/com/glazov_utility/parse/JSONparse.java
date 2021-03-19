package com.glazov_utility.parse;

import org.json.*;

import java.util.ArrayList;
import java.util.HashMap;

public class JSONparse {
    public static HashMap<String, String> CountriesStationParse(String json, String opt1, String opt2) {
        JSONArray jsonarray = new JSONArray(json);
        HashMap<String, String> stations =
                new HashMap<>();
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            String name = jsonobject.getString(opt1);
            String name2 = jsonobject.getString(opt2);
            stations.put(name, name2);
        }
        return stations;
    }
    public static HashMap<String,String> CountriesParse(String json,String opt1,String opt2) {
        JSONArray jsonarray = new JSONArray(json);
        HashMap<String,String> countries = new HashMap<>();
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            countries.put(jsonobject.getString(opt1), String.valueOf(jsonobject.getInt(opt2)));
        }
        return countries;
    }
}
