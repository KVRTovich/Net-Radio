package com.glazov_utility;
import com.glazov_utility.network.urlcon;
import com.glazov_utility.parse.JSONparse;

import java.util.HashMap;

public class Main {
    public static String Countries = "https://de1.api.radio-browser.info/json/countries";
    public static String CountriesStation = "https://de1.api.radio-browser.info/json/stations/bycountry/";

    public static void main(String[] args) throws Exception {
        HashMap<String, String> people = new HashMap<>();
        String but = urlcon.urlcon(CountriesStation + "finland");
        System.out.println(JSONparse.CountriesStationParse(but,"name", "url"));
        System.out.println(JSONparse.CountriesParse(urlcon.urlcon(Countries),"name","stationcount"));
    }
}
