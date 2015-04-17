package controller;

import java.awt.event.ActionEvent;
import outPersistense.BufferedCSVFile;
import outPersistense.CVSFileWriter;

public class SaveCommand implements Command{

    @Override
    public void execute() {
        new CVSFileWriter().writeToFile(BufferedCSVFile.getList(), "salida.csv");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        execute();
    }

    
}
