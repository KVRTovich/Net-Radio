package com.glazov_utility;
import com.glazov_utility.network.urlcon;
import com.glazov_utility.parse.JSONparse;
public class Main {
    public static String Countries = "https://de1.api.radio-browser.info/json/countries";
    public static String CountriesStation = "https://de1.api.radio-browser.info/json/stations/bycountry/";

    public static void main(String[] args) throws Exception {
        String but = urlcon.urlcon(CountriesStation + "finland");
        JSONparse.CountriesParse(but,"name", "url", "bitrate");
    }
}
