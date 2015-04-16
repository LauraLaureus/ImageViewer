package ui.swing;


import javax.swing.JFrame;
import javax.swing.JSplitPane;
import persistence.ImageDaisyChain;


public class ApplicationFrame extends JFrame {
    
    private final ImageDaisyChain daisyChain;
    
    public ApplicationFrame(ImageDaisyChain daisyChain){
        this.daisyChain = daisyChain;
        configurePanels();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

        


    private void configurePanels() {

        JSplitPane panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                new ImageDisplayer(daisyChain),
                new DataPanel());
        panel.setDividerLocation(700);
        this.setContentPane(panel);
        
    }

    
}
