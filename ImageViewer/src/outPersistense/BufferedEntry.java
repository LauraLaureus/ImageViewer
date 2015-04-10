package outPersistense;

import java.util.ArrayList;

public class BufferedEntry {

    private final ArrayList<String> entry;


    public BufferedEntry() {
        this.entry = new ArrayList<>();
    }
    
    public void setElements(String[] fields){
        for (String field : fields) {
            this.entry.add(field);
        }
    }
    
    public void append(String s){
        this.entry.add(s);
    }
    
    public int size(){
        return this.size();
    }
    
    public ArrayList<String> getRecord(){
        return this.entry;
    }
    
    public void modifyAtIndex(int index, String data){
        this.entry.remove(index);
        this.entry.add(index, data);
    }
    
    public String getAtIndex(int index){
        return this.entry.get(index);    }

    @Override
    public String toString() {
        String result = "";
        for (String field : entry) {
            result += field + ",";
        }
        return result;
    }
    
    
}
