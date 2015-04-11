package ui.swing;


import javax.swing.JFrame;
import persistence.ImageDaisyChain;


public class ApplicationFrame extends JFrame {
    
    private final ImageDaisyChain daisyChain;
    
    public ApplicationFrame(ImageDaisyChain daisyChain){
        this.daisyChain = daisyChain;
        this.addWidgets();
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void addWidgets() {
        
        addImageZone();
        
    }

    private void addImageZone() {
        this.add(new ImageZone(daisyChain, this));
    }

    
}
