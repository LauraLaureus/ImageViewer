package persistence;


import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;
import model.Observed;
import model.Observer;
import model.ProxyImage;


public class ImageDaisyChain extends TreeMap<String,ProxyImage> implements Observed {

    private final ArrayList<Entry<String,ProxyImage>> daisyChain;
    private Integer index;
    private final ArrayList<Observer> obsevers;
    
    public ImageDaisyChain(File directory) {
                
        String[] files = getFilesInDirectory(directory);
        for (String file : files) {
            this.put(file, new ProxyImage(directory.getAbsolutePath() + file));
        }
        index = 0;
        this.daisyChain = new ArrayList(this.entrySet());
        obsevers = new ArrayList<>();
    }

    

    private String[] getFilesInDirectory(File folder) {
        ArrayList<String> solution = new ArrayList<>();

        for (final File fileEntry : folder.listFiles()) {
            if (!fileEntry.isDirectory()) {
                if(isImageFile(fileEntry.getName()))
                    solution.add(fileEntry.getName());
            } 
        }
        return solution.toArray(new String[0]);
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
        if(index > 0){
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
            obsever.notice();
        }
    }
}
