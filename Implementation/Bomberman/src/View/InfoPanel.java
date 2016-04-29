package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by od on 28.4.2016.
 */
public abstract class InfoPanel extends JPanel
{
    Font customFont,customFont2, customFont3;

    public InfoPanel(String title)
    {
        super();
        setLayout(null);

        setPreferredSize(new Dimension(1024,768));


        try {
            //create the font to use. Specify the size!
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Sources/fonts/Bombing.ttf")).deriveFont(30f);
            customFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("src/Sources/fonts/Bombing.ttf")).deriveFont(180f);
            customFont3 = Font.createFont(Font.TRUETYPE_FONT, new File("src/Sources/fonts/Bombing.ttf")).deriveFont(60f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/Sources/fonts/Bombing.ttf")));
        } catch (IOException e) {
            customFont = new Font("Century", Font.PLAIN + Font.BOLD, 30);
            customFont2 = new Font("Century", Font.PLAIN + Font.BOLD, 200);
        } catch(FontFormatException e) {
            customFont = new Font("Century", Font.PLAIN + Font.BOLD, 30);
            customFont2 = new Font("Century", Font.PLAIN + Font.BOLD, 200);
        }


        JLabel titleLabel = new JLabel(title + "  ");
        titleLabel.setFont(customFont2);
        titleLabel.setSize(titleLabel.getPreferredSize());
        this.add(titleLabel);

        titleLabel.setLocation(50,20);
        titleLabel.setForeground(Color.BLUE);



        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainFrame.getInstance().changeStatus(0);
            }
        });
        backButton.setFont(customFont);
        backButton.setSize(backButton.getPreferredSize());
        this.add(backButton);
        backButton.setLocation(50,250);
        backButton.setForeground(Color.BLUE);

        setVisible(true);

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        try {
            BufferedImage b1 = ImageIO.read(new File("src/Sources/img/background3.png"));
            g.drawImage(b1, 0,0,1024,768,this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
