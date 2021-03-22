package com.glazov_utility;
import com.glazov_utility.network.urlcon;
import com.glazov_utility.parse.JSONparse;
import com.glazov_utility.parse.StringTrim;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Main {
    public static final String Countries = "https://de1.api.radio-browser.info/json/countries";
    public static final String CountriesStation = "https://de1.api.radio-browser.info/json/stations/bycountry/";
    private static String[] countriesunv;
    private static String govnovar;
    public static void GUI()  throws Exception{
        JFrame frame = new JFrame("Net Radio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(320,480));
        countriesunv = JSONparse.CountriesParse(urlcon.urlcon(Countries),"name","stationcount").toArray(new String[0]);
        JList<String> list1 = new JList<>(countriesunv);
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                   // System.out.println(list1.getSelectedValue());
                    govnovar = StringTrim.StringTrim(list1.getSelectedValue());
                  //  System.out.println(govnovar);
                    try {
                        StationSelect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        frame.pack();
        frame.setResizable(false);
        frame.add(new JScrollPane(list1));
        frame.setVisible(true);
    }
    public static void StationSelect() throws Exception {
        JFrame frame = new JFrame("Net Radio - Stations");
        frame.setPreferredSize(new Dimension(320,480));
        countriesunv = JSONparse.CountriesStationParse(urlcon.urlcon(CountriesStation + govnovar),"name","url").keySet().toArray(new String[0]);
        JList<String> list1 = new JList<>(countriesunv);
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                //    System.out.println(list1.getSelectedValue());
                    try {
                        // System.out.println(JSONparse.CountriesStationParse(urlcon.urlcon(CountriesStation + govnovar), "name", "url").get(list1.getSelectedValue()));
                        playerGUI(list1.getSelectedValue(),govnovar);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        frame.add(new JScrollPane(list1));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
    public static void playerGUI(String stationName,String CountryName) {
        JFrame frame = new JFrame("Net Radio - Player") ;
        frame.setPreferredSize(new Dimension(400,200));
        JButton play =new JButton("Play");
        JButton stop = new JButton("Stop");
        JButton pause = new JButton("Pause");
        JSlider slider3 = new JSlider(0, 100, 100);
        JLabel namestation = new JLabel(stationName, SwingConstants.CENTER);
        JLabel countryName = new JLabel(CountryName,SwingConstants.CENTER);
        play.setBounds(150,150,95,30);
        stop.setBounds(50,150,95,30);
        pause.setBounds(250,150,95,30);
        slider3.setBounds(50,125,290,20);
        namestation.setBounds(45,50,290,20);
        countryName.setBounds(45,75,290,20);
        frame.add(play);
        frame.add(stop);
        frame.add(namestation);
        frame.add(countryName);
        frame.add(pause);
        frame.add(slider3);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args){
        JFrame.setDefaultLookAndFeelDecorated(false);
        javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                GUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
