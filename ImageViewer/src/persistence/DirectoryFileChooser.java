package persistence;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;

public class DirectoryFileChooser extends JFileChooser{

    public DirectoryFileChooser() {
        this.setDialogTitle("Elegir carpeta de visualización");
        this.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }
    
    public File getElementIfItIsSuitable(Component parent){
       int i = this.showOpenDialog(parent);
       File result = null;
       
       if(i == this.getApproveOption()){
           result = this.getSelectedFile();
           System.out.println(result.getName());
       }else{ 
           System.out.println("NOP");
       }
       
       return result;
    }
    
    public String getSelectedPath(){
        return this.getCurrentDirectory() + this.getSelectedFile().getName();
    }
    
    public int getApproveOption(){
        return JFileChooser.APPROVE_OPTION;
    }
    
}
