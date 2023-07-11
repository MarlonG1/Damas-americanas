package Clases;

import java.io.File;
import javax.sound.sampled.*;

public class Reproductor {

    public static void reproducirSonido(String archivo) {
        
        String ruta = "src/SFX/" + archivo + ".wav";
        
        try {
            File fl = new File(ruta);
            AudioInputStream ais = AudioSystem.getAudioInputStream(fl);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        } catch (Exception ex) {

        }
    }
}
