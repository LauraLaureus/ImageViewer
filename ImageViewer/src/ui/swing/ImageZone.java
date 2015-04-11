package ui.swing;

import ui.swing.tools.ImagePanel;
import controller.NextImageCommand;
import controller.PrevImageCommand;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;
import persistence.ImageDaisyChain;

public class ImageZone extends JPanel {

    private final ImageDaisyChain daisyChain;
    private final Component parent;
    
    public ImageZone(ImageDaisyChain dc, Component parent) {
        this.parent = parent;
        this.daisyChain = dc;
        this.setLayout( new GridBagLayout());
        this.setSize(new Dimension(
                (int)(parent.getSize().getWidth()/2) ,
                (int) parent.getSize().getHeight()));
        addWidgets();
    }

    private void addWidgets() {
        addImagePanel();
        addNextButton();
        addPreviousButton();
    }

    
    private void addImagePanel() {
        Insets defaultInsets = new Insets(0, 0, 0, 0);
        GridBagConstraints c = new GridBagConstraints(
                0,
                0,
                3,
                3,
                0,
                0,
                GridBagConstraints.NORTHEAST, 
                GridBagConstraints.BOTH, 
                defaultInsets,
                10,
                10);
        add(new ImagePanel(this.daisyChain,this),c);
    }

    private void addNextButton() {
        Insets defaultInsets = new Insets(0, 10, 10, 0);
        GridBagConstraints c = new GridBagConstraints(
                2,
                3,
                1,
                1,
                0,
                0,
                GridBagConstraints.NORTHEAST, 
                GridBagConstraints.NONE, 
                defaultInsets,
                10,
                10);
        JButton next = new JButton("Siguiente");
        next.addActionListener(new NextImageCommand(this.daisyChain,parent));
        add(next,c);
    }

    private void addPreviousButton() {
        Insets defaultInsets = new Insets(0, 0, 10, 10);
        GridBagConstraints c = new GridBagConstraints(
                0,
                3,
                1,
                1,
                0,
                0,
                GridBagConstraints.NORTHEAST, 
                GridBagConstraints.NONE, 
                defaultInsets,
                10,
                10);
        JButton prev = new JButton("Anterior");
        prev.addActionListener(new PrevImageCommand(daisyChain, parent));
        add(prev,c);
    }

    
}
