package View;

import Controller.GameManager;

import javax.swing.*;
import java.awt.*;

/**
 * Created by od on 28.4.2016.
 */
public class SettingsPanel extends InfoPanel
{
    private GameManager gManager;

    public SettingsPanel(GameManager manager)
    {
        super("Settings  ");

        gManager = manager;

        JTextArea bg = new JTextArea("Background Music");


        bg.setSize(new Dimension(400,200));

        bg.setFont(customFont3);
        bg.setLineWrap(true);
        bg.setEditable(false);
        bg.setVisible(true);

        bg.setForeground(Color.BLUE);
        bg.setOpaque(false);

        this.add(bg);
        bg.setLocation(50,350);

        JCheckBox bgcb = new JCheckBox();
        bgcb.setSize(new Dimension(50,50));
        bgcb.setFont(customFont);
        bgcb.setVisible(true);
        bgcb.setForeground(Color.BLUE);
        bgcb.setOpaque(false);
        bgcb.setSelected(gManager.isBgOn());


        this.add(bgcb);
        bgcb.setLocation(450,350);

        JTextArea sound = new JTextArea("Sound Effects");


        sound.setSize(new Dimension(400,200));

        sound.setFont(customFont3);
        sound.setLineWrap(true);
        sound.setEditable(false);
        sound.setVisible(true);

        sound.setForeground(Color.BLUE);
        sound.setOpaque(false);

        this.add(sound);
        sound.setLocation(50,450);

        JCheckBox soundcb = new JCheckBox();
        soundcb.setSize(new Dimension(50,50));
        soundcb.setFont(customFont);
        soundcb.setVisible(true);
        soundcb.setForeground(Color.BLUE);
        soundcb.setOpaque(false);
        soundcb.setSelected(manager.isSoundOn());

        this.add(soundcb);
        soundcb.setLocation(450,450);

        JTextArea volume = new JTextArea("Master Volume");


        volume.setSize(new Dimension(400,200));

        volume.setFont(customFont3);
        volume.setLineWrap(true);
        volume.setEditable(false);
        volume.setVisible(true);

        volume.setForeground(Color.BLUE);
        volume.setOpaque(false);

        this.add(volume);
        volume.setLocation(50,550);

        JSlider volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, manager.getMusicLevel());

        volumeSlider.setSize(new Dimension(400,100));
        volumeSlider.setVisible(true);

        volumeSlider.setOpaque(false);

        this.add(volumeSlider);
        volumeSlider.setLocation(450,550);
    }

}
