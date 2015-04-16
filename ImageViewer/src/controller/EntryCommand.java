package controller;

import java.awt.event.ActionEvent;
import outPersistense.BufferedCSVFile;
import outPersistense.BufferedEntry;

public class EntryCommand implements Command {

    private String nombre;
    private String sexo;
    private String cuadrante;
    private static final BufferedCSVFile bufferedFile = new BufferedCSVFile(3);
    
    public EntryCommand(String fileName,String sexo, String cuadrante) {
        this.sexo = sexo;
        this.cuadrante = cuadrante;
        this.nombre = fileName;
    }
    
    
    @Override
    public void execute() {
        addEntryToBuffer(createEntry());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        execute();
    }
    
    private BufferedEntry createEntry(){
        BufferedEntry record =  new BufferedEntry();
        record.append(nombre);
        record.append(sexo);
        record.append(cuadrante);
        return record;
    }

    private void addEntryToBuffer(BufferedEntry createEntry) {
        this.bufferedFile.setEntry(createEntry);
    }
}
