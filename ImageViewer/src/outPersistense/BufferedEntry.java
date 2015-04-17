package outPersistense;

import java.util.ArrayList;
import java.util.Objects;

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
        return this.entry.size();
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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BufferedEntry other = (BufferedEntry) obj;
        if (!Objects.equals(this.entry, other.entry)) {
            return false;
        }
        return true;
    }
    
    
}
