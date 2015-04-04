package imageviewer;

import javax.swing.JFrame;
import persistence.DirectoryFileChooser;
import persistence.ImageDaisyChain;





public class SwingApplication {

   
    public static void main(String[] args) {
       JFrame window = new JFrame();
       new ImageDaisyChain(
               new DirectoryFileChooser().getElementIfItIsSuitable(window));
       
    }
   
    
    
    
}
