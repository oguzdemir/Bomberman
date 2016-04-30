package View;

import Controller.GameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by od on 28.4.2016.
 */
public class SettingsPanel extends InfoPanel
{
    private JCheckBox bgcb;
    private JCheckBox soundcb;
    private JSlider volumeSlider;

    public SettingsPanel(String settings)
    {
        super("Settings  ");


        JTextArea bg = new JTextArea("Background Music");

        boolean bgOn = Boolean.parseBoolean(settings.split(" ")[0]);
        boolean soundOn = Boolean.parseBoolean(settings.split(" ")[1]);
        int musicLevel = Integer.parseInt(settings.split(" ")[2]);

        bg.setSize(new Dimension(400,200));

        bg.setFont(customFont3);
        bg.setLineWrap(true);
        bg.setEditable(false);
        bg.setVisible(true);

        bg.setForeground(Color.BLUE);
        bg.setOpaque(false);

        this.add(bg);
        bg.setLocation(50,350);

        bgcb = new JCheckBox();
        bgcb.setSize(new Dimension(50,50));
        bgcb.setFont(customFont);
        bgcb.setVisible(true);
        bgcb.setForeground(Color.BLUE);
        bgcb.setOpaque(false);
        bgcb.setSelected(bgOn);


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

        soundcb = new JCheckBox();
        soundcb.setSize(new Dimension(50,50));
        soundcb.setFont(customFont);
        soundcb.setVisible(true);
        soundcb.setForeground(Color.BLUE);
        soundcb.setOpaque(false);
        soundcb.setSelected(soundOn);

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

        volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, musicLevel);

        volumeSlider.setSize(new Dimension(400,100));
        volumeSlider.setVisible(true);

        volumeSlider.setOpaque(false);

        this.add(volumeSlider);
        volumeSlider.setLocation(450,550);



        JButton saveButton = new JButton("Save Changes");
        saveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainFrame.getInstance().saveSettings( bgcb.isSelected() + " " + soundcb.isSelected() + " " + volumeSlider.getValue());
                MainFrame.getInstance().changeStatus(0);
            }
        });
        saveButton.setFont(customFont);
        saveButton.setSize(saveButton.getPreferredSize());
        this.add(saveButton);
        saveButton.setLocation(650,650);
        saveButton.setForeground(Color.BLUE);
    }

}
