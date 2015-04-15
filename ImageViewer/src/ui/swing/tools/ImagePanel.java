package ui.swing.tools;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Observed;
import model.Observer;
import persistence.ImageDaisyChain;

public class ImagePanel extends JPanel implements Observer {

    private BufferedImage image;
    private final Component parent;
    private ImageRuleContainer rules;

    public ImagePanel(ImageDaisyChain dc, Component parent) {
        this.parent = parent;
        addListeners();

        image = dc.getCurrent();
        dc.hook(this);
        refresh();

        createImageRules();

        setThisComponentRules();

    }

    private void addListeners() {
        addComponentListener();
        //addMouseListener();
    }

    private void setThisComponentRules() {
        this.setSize(new Dimension(parent.getWidth(), parent.getHeight()));
        this.setMaximumSize(new Dimension(parent.getWidth(), parent.getHeight()));
    }

    private void refresh() {
        this.removeAll();
        JLabel picLabel = new JLabel(new ImageIcon(this.image));
        picLabel.setSize(this.getSize());
        add(picLabel);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawRules(image).dispose();

    }

    @Override
    public void notice(Observed o) {
        ImageDaisyChain dc = (ImageDaisyChain) o;
        image = dc.getCurrent();
        refresh();
        repaint();
    }

    

    private void addComponentListener() {
        parent.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                repaint();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                repaint();
            }

            @Override
            public void componentShown(ComponentEvent e) {
                repaint();
            }

            @Override
            public void componentHidden(ComponentEvent e) {
            }
        });
    }

    

    private void createImageRules() {
        this.rules = new ImageRuleContainer();
        this.rules.add(new ImageRule() {

            @Override
            public Graphics2D drawRule(Graphics2D g2d) {
                g2d.setColor(Color.red);
                g2d.drawLine(image.getWidth() / 3, 0, image.getWidth() / 3, image.getHeight());
                g2d.drawLine(2 * image.getWidth() / 3, 0, 2 * image.getWidth() / 3, image.getHeight());
                g2d.drawLine(0, image.getHeight() / 3, image.getWidth(), image.getHeight() / 3);
                g2d.drawLine(0, 2 * image.getHeight() / 3, image.getWidth(), 2 * image.getHeight() / 3);
                return g2d;
            }
        });

        
    }

    private Graphics2D drawRules(BufferedImage img) {
        Graphics2D g2d = img.createGraphics();

        for (ImageRule rule : rules) {
            g2d = rule.drawRule(g2d);
        }

        return g2d;
    }

    
}
