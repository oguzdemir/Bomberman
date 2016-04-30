package Controller;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.nio.file.Paths;

/**
 * Controller class for the sounds of the game.
 *
 * Created by Anıl Sert on 29.04.2016.
 */
public class SoundManager {
    private String backgroundMusic;

    public SoundManager ()
    {
        backgroundMusic = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
    }

    public void playBackgroundMusic(int volume) {
        MediaPlayer mp = new MediaPlayer(new Media(backgroundMusic));
                    /*AudioInputStream inputStream = AudioSystem.getAudioInputStream(this.getClass().getResource(backgroundMusic));
                    Clip clip = AudioSystem.getClip();
                    Media
                    clip.open(inputStream);
                    FloatControl gainControl =
                            (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(volume);
                    clip.start();*/
        mp.play();
    }

    public void playSound(int situation, int volume)
    {

    }
}
