package outPersistense;

import java.util.ArrayList;

public class BufferedCSVFile implements BufferedFile {

    private final int numFields;
    private final ArrayList<BufferedEntry> file;
    private int index;

    public BufferedCSVFile(int numFields) {
        this.numFields = numFields;
        this.file = new ArrayList<>();
        index = 0;
    }

    @Override
    public void setEntry(BufferedEntry e) {
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
        index++;
    }

    public void modifyEntry(int index, BufferedEntry buff) {
        BufferedEntry asked = getEntry(index);
        
        for (int i = 0; i < buff.size(); i++) {
            asked.modifyAtIndex(i, buff.getAtIndex(i));
        }
    }

    private BufferedEntry getEntry(int index) {
        return file.get(index);
    }
}
