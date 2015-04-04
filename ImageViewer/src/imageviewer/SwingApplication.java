package imageviewer;

import javax.swing.JFrame;
import persistence.DirectoryFileChooser;





public class SwingApplication {

    //FOR NEXT VERSIONS: seleccionar la carpeta desde donde queremos leer las imágenes.
    public static void main(String[] args) {
       JFrame window = new JFrame();
       window.setVisible(true);
       new DirectoryFileChooser().getElementIfItIsSuitable(window);
       
    }
   
    
    
    
}
