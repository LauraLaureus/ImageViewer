package ui.swing.tools;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import model.Observed;
import model.Observer;
import persistence.ImageDaisyChain;

public class ImageSquare extends JPanel implements Observer{

    private final ImageDaisyChain daisyChain;
    private BufferedImage image;
    
    private final Dimension size;
    
    public ImageSquare(ImageDaisyChain daisyChain,Dimension assigned) {
        this.daisyChain = daisyChain;
        this.daisyChain.hook(this);

        this.image = daisyChain.getCurrent();
        this.size = assigned;
        setThisConstraints();
    }

    private void setThisConstraints() {
        setThisSize();
    }

    private void setThisSize() {
        this.setBounds(0, 0, 1200 , 6000);
    }
   

    @Override
    public void notice(Observed o) {
        ImageDaisyChain dc = (ImageDaisyChain) o;
        image = dc.getCurrent();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g.drawImage(image, 0, 0,null);
        g.dispose();
    }
    
    
    
    
}
