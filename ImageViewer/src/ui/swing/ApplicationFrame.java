package ui.swing;

import controller.NextImageCommand;
import controller.PrevImageCommand;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
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
        add(new ImagePanel(this.daisyChain),c);
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
        next.addActionListener(new NextImageCommand(this.daisyChain,this));
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
        prev.addActionListener(new PrevImageCommand(daisyChain, this));
        add(prev,c);
    }

    
}
