package application;

import javax.swing.JFrame;
import inPersistence.DirectoryFileChooser;
import inPersistence.ImageDaisyChain;
import ui.swing.ApplicationFrame;

public class SwingApplication {

   
    public static void main(String[] args) {
        ImageDaisyChain daisyChain = new ImageDaisyChain(
               new DirectoryFileChooser().getElementIfItIsSuitable(new JFrame()));
        new ApplicationFrame(daisyChain);
       
    }
   
    
    
    
}
