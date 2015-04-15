package ui.swing;


import javax.swing.JFrame;
import javax.swing.JSplitPane;
import persistence.ImageDaisyChain;
import ui.swing.tools.ImagePanel;


public class ApplicationFrame extends JFrame {
    
    private final ImageDaisyChain daisyChain;
    
    public ApplicationFrame(ImageDaisyChain daisyChain){
        this.daisyChain = daisyChain;
        configurePanels();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void addWidgets() {
        
        addImageZone();
        
    }

    private void addImageZone() {
        this.add(new ImageZone(daisyChain, this));}

    private void configurePanels() {

        JSplitPane panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                new ImagePanel(daisyChain, this),
                new ImageZone(daisyChain, this));
        panel.setDividerLocation(250);
        this.setContentPane(panel);
        
    }

    
}
