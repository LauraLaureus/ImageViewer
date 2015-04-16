package ui.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import model.Observed;
import model.Observer;
import persistence.ImageDaisyChain;

public class ImageDisplayer extends javax.swing.JPanel implements Observer {

    private final ImageDaisyChain daisychain;
    private BufferedImage image;
    
    public ImageDisplayer( ImageDaisyChain dc) {
        this.daisychain = dc;
        this.daisychain.hook(this);
        this.image = daisychain.getCurrent();
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void notice(Observed o) {
        refreshImage();
        repaint();
    }

    private void refreshImage() {
        this.image = daisychain.getCurrent();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        g.setColor(Color.red);
        g.drawLine(this.getWidth()/3, 0, this.getWidth()/3, this.getHeight());
        g.drawLine(2*this.getWidth()/3, 0, 2*this.getWidth()/3, this.getHeight());
        g.drawLine(0, this.getHeight()/3, this.getWidth(), this.getHeight()/3);
        g.drawLine(0, 2*this.getHeight()/3, this.getWidth(), 2*this.getHeight()/3);
    }
    
    
}
