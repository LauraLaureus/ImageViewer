package outPersistense;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CVSFileWriter implements FileWriter{

    @Override
    public void writeToFile(Object[] buff, String name) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("out.csv", "UTF-8");
            
            
            for (Object entry : buff) {
                writer.print(entry);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CVSFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CVSFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            writer.close();
        }
        
        
    }

    
}
