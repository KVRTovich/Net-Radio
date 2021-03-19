package com.glazov_utility.parse;

import org.json.*;

public class JSONparse {
    public static void CountriesParse(String json,String opt1,String opt2,String opt3) {
        JSONArray jsonarray = new JSONArray(json);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            String name = jsonobject.getString(opt1);
            String name2 = jsonobject.getString(opt2);
            int num = jsonobject.getInt(opt3);
            System.out.println(name);
            System.out.println(name2);
            System.out.println(num);
        }
    }
}
