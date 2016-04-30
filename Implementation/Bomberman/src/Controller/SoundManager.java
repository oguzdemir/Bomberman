package Controller;



import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;
import  sun.audio.*;    //import the sun.audio package
import  java.io.*;
import java.io.InputStream;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 * Controller class for the sounds of the game.
 *
 * Created by Oğuz Demir on 30.04.2016.
 */
class SoundManager{

    private  String resource;

    private Clip clip;
    private FloatControl gainControl;

    /**
     * Constructor for the sound manager.
     * @param resource name of the sound file.
     */
    public SoundManager(String resource) {
        //gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        this.resource = "Sources/wav/" + resource;
    }

    /**
     * Change the volume of the sounds.
     * @param volume level.
     */
    public void changeVolume(int volume)
    {
        switch(volume)
        {
            /*case 1:
                gainControl.setValue(-90.0f);
                break;
            case 2:
                gainControl.setValue(-80.0f);
                break;
            case 3:
                gainControl.setValue(-70.0f);
                break;
            case 4:
                gainControl.setValue(-60.0f);
                break;
            case 5:
                gainControl.setValue(-50.0f);
                break;
            case 6:
                gainControl.setValue(-40.0f);
                break;
            case 7:
                gainControl.setValue(-30.0f);
                break;
            case 8:
                gainControl.setValue(-20.0f);
                break;
            case 9:
                gainControl.setValue(-10.0f);
                break;
            case 10:
                gainControl.setValue(0);
                break;*/
            default:
                break;
        }

    }

    /**
     * Stops the sound clip.
     */
    public void stop() {
        if(clip!= null)
            clip.stop();
    }


    /**
     * Plays the sound clip.
     */
    public void play() {
        clip = null;
        try {
            InputStream in = SoundManager.class.getClassLoader().getResourceAsStream(resource);
            if(in != null) {
                AudioInputStream stream = AudioSystem.getAudioInputStream(in);
                AudioFormat format = stream.getFormat();
                DataLine.Info info = new DataLine.Info(Clip.class, format);
                clip = (Clip) AudioSystem.getLine(info);
                clip.open(stream);
                clip.loop(0);
                do  {
                    try {
                        Thread.sleep(100);
                    } catch(InterruptedException iex) {
                        // bad form on my part here. Should do somethinging
                    }
                } while(clip.isRunning());
            }
        } catch (Exception e) {
            System.out.println("lol");
        } finally {
            try {
                if(clip != null) {
                    clip.close();
                }
            } catch(Exception x) {
                x.printStackTrace(System.out);
            }
        }
    }

    public void play(boolean b) {
        Clip clip = null;
        try {
            InputStream in = SoundManager.class.getClassLoader().getResourceAsStream(resource);
            if(in != null) {
                AudioInputStream stream = AudioSystem.getAudioInputStream(in);
                AudioFormat format = stream.getFormat();
                DataLine.Info info = new DataLine.Info(Clip.class, format);
                clip = (Clip) AudioSystem.getLine(info);
                clip.open(stream);
                clip.loop(1);
                do  {
                    try {
                        Thread.sleep(100);
                    } catch(InterruptedException iex) {
                        // bad form on my part here. Should do somethinging
                    }
                } while(clip.isRunning());
            }
        } catch (Exception e) {
            System.out.println("lol");
        } finally {
            try {
                if(clip != null) {
                    clip.close();
                }
            } catch(Exception x) {
                x.printStackTrace(System.out);
            }
        }
    }
}