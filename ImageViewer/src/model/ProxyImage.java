package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class ProxyImage 
{

    private final String name;
    private BufferedImage img;
    
    public ProxyImage(String name) {
        this.name = name;
    }
    
    public BufferedImage getImage(){
        if(img == null){
            try {
                this.img = ImageIO.read(new File(this.name));
            } catch (IOException ex) {
                Logger.getLogger(ProxyImage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.img;
    }
}
