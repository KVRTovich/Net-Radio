package com.glazov_utility;
import com.glazov_utility.network.urlcon;
public class Main {
    public static String Countries = "https://de1.api.radio-browser.info/json/countries";
    public static String CountriesStation = "https://de1.api.radio-browser.info/json/stations/bycountry/";
    public static void main(String[] args) throws Exception {
        System.out.println(urlcon.urlcon(CountriesStation + "finland"));
    }
}
