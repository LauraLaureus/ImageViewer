package ui.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Observed;
import model.Observer;
import persistence.ImageDaisyChain;

public class ImagePanel extends JPanel implements Observer{

    private BufferedImage image;

    public ImagePanel(ImageDaisyChain dc) {
        image = dc.getCurrent();
        dc.hook(this);
        JLabel picLabel = new JLabel(new ImageIcon(image));
        add(picLabel);
        this.setMinimumSize(new Dimension(image.getWidth(), image.getHeight()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.red);
        g2d.drawLine(image.getWidth()/3, 0, image.getWidth()/3, image.getHeight());
        g2d.drawLine(2*image.getWidth()/3, 0, 2*image.getWidth()/3, image.getHeight());
        g2d.drawLine( 0, image.getHeight()/3,image.getWidth(), image.getHeight()/3);
        g2d.drawLine(0,2*image.getHeight()/3,image.getWidth(),2*image.getHeight()/3);
        g2d.dispose();
        //g.drawImage(image, 0, 0, null); 
    }

    @Override
    public void notice(Observed o) {
        ImageDaisyChain dc = (ImageDaisyChain) o;
        image = dc.getCurrent();
        remove(0);
        
    }
    
   

}
