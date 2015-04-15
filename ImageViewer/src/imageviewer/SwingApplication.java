package imageviewer;

import javax.swing.JFrame;
import persistence.DirectoryFileChooser;
import persistence.ImageDaisyChain;
import ui.swing.ApplicationFrame;

public class SwingApplication {

   
    public static void main(String[] args) {
        ImageDaisyChain daisyChain = new ImageDaisyChain(
               new DirectoryFileChooser().getElementIfItIsSuitable(new JFrame()));
        //new ApplicationFrame(daisyChain);
       
    }
   
    
    
    
}
