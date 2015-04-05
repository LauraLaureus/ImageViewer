package imageviewer;

import javax.swing.JFrame;
import persistence.DirectoryFileChooser;
import persistence.ImageDaisyChain;
import ui.swing.SwingImagePanel;





public class SwingApplication {

   
    public static void main(String[] args) {
       JFrame window = new JFrame();
       window.add(new SwingImagePanel(new ImageDaisyChain(
               new DirectoryFileChooser().getElementIfItIsSuitable(window))));
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       window.setVisible(true);
       
    }
   
    
    
    
}
