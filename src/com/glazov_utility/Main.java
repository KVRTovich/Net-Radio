package com.glazov_utility;
import com.glazov_utility.network.urlcon;
import com.glazov_utility.parse.JSONparse;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Main {
    public static String Countries = "https://de1.api.radio-browser.info/json/countries";
    public static String CountriesStation = "https://de1.api.radio-browser.info/json/stations/bycountry/";
    private static String[] countriesunv;
    private static String govnovar;
    public static void GUI()  throws Exception{
        JFrame frame = new JFrame("Net Radio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(640,480));
        countriesunv = JSONparse.CountriesParse(urlcon.urlcon(Countries),"name","stationcount").keySet().toArray(new String[0]);
        JList<String> list1 = new JList<String>(countriesunv);
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    //...Show the JDialog or JOptionPane here, not JPanel.
                    System.out.println(list1.getSelectedValue().toString());
                    govnovar = list1.getSelectedValue().toString();
                    try {
                        StationSelect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        frame.pack();
        frame.add(new JScrollPane(list1));
        frame.setVisible(true);
    }
    public static void StationSelect() throws Exception {
        JFrame frame = new JFrame("Net Radio - Stations");
        frame.setPreferredSize(new Dimension(640,480));
        countriesunv = JSONparse.CountriesStationParse(urlcon.urlcon(CountriesStation + govnovar),"name","url").keySet().toArray(new String[0]);
        JList<String> list1 = new JList<String>(countriesunv);
        frame.add(new JScrollPane(list1));
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        JFrame.setDefaultLookAndFeelDecorated(false);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    GUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
