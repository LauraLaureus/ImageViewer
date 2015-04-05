package ui.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import model.Observer;
import persistence.ImageDaisyChain;

public class SwingImagePanel extends JPanel implements Observer {

    private final ImageDaisyChain daisyChain;

    public SwingImagePanel(ImageDaisyChain daisyChain) {
        this.daisyChain = daisyChain;
        this.daisyChain.hook((Observer)this);
        this.addWidgets();
    }

    @Override
    public void notice() {
        /*
            vuelve y lee la imagen 
        */
    }

    private void addWidgets() {
        add(createDisplayPanel());
    }

    private JPanel createDisplayPanel() {
        return new JPanel(){
            {
                this.addComponentListener(createComponentListener());
            }
            
            @Override
            public void paint(Graphics g) {
                super.paint(g); 
                BufferedImage current = daisyChain.getCurrent();
                int w = current.getWidth();
                int h = current.getHeight();
                g.drawImage(current, 0, 0, getWidth(), getHeight(), null);
                g.setColor(Color.red);
                g.drawLine(w/3, 0, w/3, h);
                g.drawLine(2*w/3, 0, 2*w/3, h);
                g.drawLine(0, h/3, w, h/3);
                g.drawLine(0, 2*h/3, w, 2*h/3);
            }

            private ComponentListener createComponentListener() {
                return new ComponentListener() {

                    @Override
                    public void componentResized(ComponentEvent e) {
                        revalidate();
                    }

                    @Override
                    public void componentMoved(ComponentEvent e) {
                    }

                    @Override
                    public void componentShown(ComponentEvent e) {
                    }

                    @Override
                    public void componentHidden(ComponentEvent e) {
                    }
                };
            }
        };
    }
    
    
}
