package com.glazov_utility.player;
import uk.co.caprica.vlcj.player.component.AudioPlayerComponent;


import java.net.URL;

public class player {
    private static AudioPlayerComponent audioplayer = new AudioPlayerComponent();
    public static int volume = 100;
    public static void play(URL url) {
        audioplayer.mediaPlayer().media().play(String.valueOf(url));
    }
    public static void volumecontrol() {
        audioplayer.mediaPlayer().audio().setVolume(volume);
    }
    public static void stop() {
        audioplayer.mediaPlayer().controls().stop();
    }
}
