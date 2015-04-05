package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class ProxyImage 
{

    private final File file;
    private BufferedImage img;
    
    public ProxyImage(File file) {
        this.file = file;
    }
    
    
    public BufferedImage getImage(){
        if(img == null){
            try {
                this.img = ImageIO.read(file);
            } catch (IOException ex) {
                ex.printStackTrace();
                Logger.getLogger(ProxyImage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.img;
    }
}
