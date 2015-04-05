package ui.swing;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import persistence.ImageDaisyChain;


public class ApplicationFrame extends JFrame {
    
    private final ImageDaisyChain daisyChain;
    
    public ApplicationFrame(ImageDaisyChain daisyChain){
        this.daisyChain = daisyChain;
        this.setLayout( new GridBagLayout());
        this.addWidgets();
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void addWidgets() {
        
        addImagePanel();
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
        add(new ImagePanel(this.daisyChain),c);
    }

    
}
