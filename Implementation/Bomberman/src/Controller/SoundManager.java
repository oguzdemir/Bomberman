package Controller;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

/**
 * Controller class for the sounds of the game.
 *
 * Created by Anıl Sert on 29.04.2016.
 */
public class SoundManager {
    private String backgroundMusic;

    public SoundManager ()
    {
        backgroundMusic = "src/Sources/bg.mp3";
    }

    public void playBackgroundMusic(int volume) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(backgroundMusic));
                    clip.open(inputStream);
                    FloatControl gainControl =
                            (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(volume);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }

    public void playSound(int situation, int volume)
    {

    }
}
