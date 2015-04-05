package controller;

import java.awt.event.ActionEvent;
import persistence.ImageDaisyChain;
import ui.swing.ApplicationFrame;

public class NextImageCommand implements Command {

    private final ImageDaisyChain viewer;
    private final ApplicationFrame parent;
    
    public NextImageCommand(ImageDaisyChain dc, ApplicationFrame af) {
        this.viewer = dc;
        parent = af;
    }

    @Override
    public void execute() {
        this.viewer.getNext();
        this.parent.revalidate();
        //this.parent.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
}
