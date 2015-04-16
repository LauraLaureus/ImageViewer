package persistence;


import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;
import model.Observed;
import model.Observer;
import model.ProxyImage;


public class ImageDaisyChain extends TreeMap<File,ProxyImage> implements Observed {

    private final ArrayList<Entry<File,ProxyImage>> daisyChain;
    private int index;
    private final ArrayList<Observer> obsevers;
    
    public ImageDaisyChain(File directory) {
                
         ArrayList<File> files = getFilesInDirectory(directory);
        for (File file : files) {
            this.put(file, new ProxyImage(file));
        }
        index = 0;
        this.daisyChain = new ArrayList(this.entrySet());
        obsevers = new ArrayList<>();
    }

    

    private ArrayList<File> getFilesInDirectory(File folder) {
        ArrayList<File> solution = new ArrayList<>();

        for (final File fileEntry : folder.listFiles()) {
            if (!fileEntry.isDirectory()) {
                if(isImageFile(fileEntry.getName()))
                    solution.add(fileEntry);
            } 
        }
        return solution;
    }

    private boolean isImageFile(String name) {
    
        return name.endsWith(".jpg") || 
            name.endsWith(".jpeg") ||
            name.endsWith(".png");
    }
    
    
    public BufferedImage getNext(){
        index++;
        if(index< this.daisyChain.size()){
            talk();
            return this.daisyChain.get(index).getValue().getImage();
        }else{
            index--;
        }
        return null;
    }
    
    public BufferedImage getPrevious(){
        index--;
        if(index >= 0){
            talk();
            return this.daisyChain.get(index).getValue().getImage();
        }else{
            index++; 
        }
        return null;
    }

    public BufferedImage getCurrent(){
        return this.daisyChain.get(index).getValue().getImage();
    }
    
    @Override
    public void hook(Observer ob) {
        obsevers.add(ob);
    }

    @Override
    public void talk() {
        for (Observer obsever : obsevers) {
            obsever.notice(this);
        }
    }
    
    public String getCurrentTitle(){
        return this.daisyChain.get(index).getValue().getTitle();
    }
}
