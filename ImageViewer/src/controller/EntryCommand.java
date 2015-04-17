package controller;

import java.awt.event.ActionEvent;
import outPersistense.BufferedCSVFile;
import outPersistense.BufferedEntry;

public class EntryCommand implements Command {

    private final String nombre;
    private final String sexo;
    private final String cuadrante;

    public EntryCommand(String fileName, String sexo, String cuadrante) {
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

    private BufferedEntry createEntry() {
        BufferedEntry record = new BufferedEntry();
        record.append(nombre);
        record.append(sexo);
        record.append(cuadrante);
        return record;
    }

    private void addEntryToBuffer(BufferedEntry createEntry) {
        if (BufferedCSVFile.lastEntryIsDiferentThanCurrent(createEntry)) {
            BufferedCSVFile.setEntry(createEntry);
        }else{
            BufferedCSVFile.modifyEntry(BufferedCSVFile.getCurrentIndex(), createEntry);
        }
    }
}
