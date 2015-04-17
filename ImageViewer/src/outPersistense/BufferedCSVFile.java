package outPersistense;

import java.util.ArrayList;

public class BufferedCSVFile  {

    private static final int numFields = 3;
    private static final ArrayList<BufferedEntry> file= new ArrayList<>();
    private static int index = 0;


    public static void setEntry(BufferedEntry e) {
        BufferedEntry entry = new BufferedEntry();
        if (e.size() > numFields) {
            int i = 0;
            for (String field : e.getRecord()) {
                entry.append(field);
                i++;
            }
        } else {
            entry = e;
        }
        file.add(entry);
    }

    public static void modifyEntry(int index, BufferedEntry buff) {
        BufferedEntry asked = getEntry(index);

        for (int i = 0; i < buff.size(); i++) {
            asked.modifyAtIndex(i, buff.getAtIndex(i));
        }
    }

    public static BufferedEntry getEntry(int index) {
        return file.get(index);
    }

    public static boolean lastEntryIsDiferentThanCurrent(BufferedEntry createEntry) {
        if(index-1 < 0 || index > file.size()) return true;
        BufferedEntry previous = getEntry(index-1);
        return previous.getAtIndex(0).equalsIgnoreCase(createEntry.getAtIndex(0));
    }

    

    public static Object[] getList(){
        return file.toArray();
    }
    
    public static void increaseIndex(){
        index++;
    }
    
    public static void decreaseIndex(){
        index--;
    }
    
    public static int getCurrentIndex(){
        return index;
    }
}
