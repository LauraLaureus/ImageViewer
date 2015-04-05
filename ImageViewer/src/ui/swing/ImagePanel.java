package ui.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import persistence.ImageDaisyChain;

public class ImagePanel extends JPanel {

    private BufferedImage image;

    public ImagePanel(ImageDaisyChain dc) {
        image = dc.getCurrent();
        JLabel picLabel = new JLabel(new ImageIcon(image));
        add(picLabel);
        this.setMinimumSize(new Dimension(image.getWidth(), image.getHeight()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); 
        
    }

}
